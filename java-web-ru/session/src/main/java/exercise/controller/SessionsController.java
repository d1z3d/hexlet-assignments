package exercise.controller;

import java.util.Collections;

import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.model.User;
import exercise.repository.UsersRepository;

import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import org.checkerframework.checker.units.qual.C;

public class SessionsController {

    // BEGIN
    public static void index(Context context) {
        var user = (User) context.sessionAttribute("currentUser");
        var mainPage = new MainPage(user);
        context.render("index.jte", Collections.singletonMap("mainPage", mainPage));
    }
    public static void build(Context context) {
        var session = context.sessionAttribute("currentUser");
        if (session == null) {
            context.render("build.jte");
        } else {
            context.redirect(NamedRoutes.rootPath());
        }
    }

    public static void login(Context context) {
        var name = context.formParam("name");
        var password = context.formParam("password");
        if (name != null && password != null && UsersRepository.existsByName(name)) {
            var user = UsersRepository.findByName(name);
            if (user.getPassword().equals(Security.encrypt(password))) {
                context.sessionAttribute("currentUser", user);
                context.redirect(NamedRoutes.rootPath());
            } else {
                var error = "Wrong name or password";
                var loginPage = new LoginPage(name, error);
                context.render("build.jte", Collections.singletonMap("loginPage", loginPage));
            }
        } else {
            var error = "Wrong name or password";
            var loginPage = new LoginPage(name, error);
            context.render("build.jte", Collections.singletonMap("loginPage", loginPage));
        }
    }

    public static void logout(Context context) {
        context.sessionAttribute("currentUser", null);
        context.redirect(NamedRoutes.rootPath());
    }
    // END
}
