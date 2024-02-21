package exercise;

import io.javalin.Javalin;
import java.util.List;
import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", context -> {
            var usersPage = new UsersPage(USERS);
            context.render("users/index.jte",
                    Collections.singletonMap("usersPage", usersPage));
        });

        app.get("/users/{id}", context -> {
            boolean isContains = false;
            long id = context.pathParamAsClass("id", long.class).get();
            for (var user : USERS) {
                if (user.getId() == id) {
                    isContains = true;
                    UserPage userPage = new UserPage(user);
                    context.render("users/show.jte", Collections.singletonMap("userPage", userPage));
                }
            }
            if (!isContains) {
                context.status(404);
                context.result("User not found");
            }
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
