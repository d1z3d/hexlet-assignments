package exercise.controller;

import org.apache.commons.lang3.StringUtils;
import exercise.util.Security;
import exercise.model.User;
import exercise.util.NamedRoutes;

import java.util.Collections;

import exercise.repository.UserRepository;
import io.javalin.http.NotFoundResponse;
import io.javalin.http.Context;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context context) {
        var firstName = StringUtils.capitalize(context.formParam("firstName"));
        var lastName = StringUtils.capitalize(context.formParam("lastName"));
        var email = context.formParam("email").trim().toLowerCase();
        var password = Security.encrypt(context.formParam("password"));
        var token = Security.generateToken();
        var user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);
        context.redirect(NamedRoutes.userPath(user.getId()));
        context.cookie("token", token);
    }

    public static void show(Context context) {
        var tokenCookie = context.cookie("token");
        if (tokenCookie != null) {
            var id = context.pathParamAsClass("id", Long.class).get();
            var user = UserRepository.find(id)
                    .orElseThrow(() -> new NotFoundResponse("User not found"));
            if (user.getToken().equals(tokenCookie) || user.getId().equals(id)) {
                context.render("users/show.jte", Collections.singletonMap("user", user));
            } else {
                context.redirect(NamedRoutes.buildUserPath());
            }
        } else {
            context.redirect(NamedRoutes.buildUserPath());
        }
    }
    // END
}
