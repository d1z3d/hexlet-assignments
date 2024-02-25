package exercise;

import exercise.repository.UsersRepository;
import io.javalin.Javalin;
import exercise.controller.SessionsController;
import exercise.util.NamedRoutes;


public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get(NamedRoutes.rootPath(), SessionsController::index);
        //TODO: 3 endpoints
        //GET /sessions/build — форма логина, в которой пользователь вводит имя и пароль
        app.get(NamedRoutes.buildSessionPath(), SessionsController::build);
        //POST /sessions для создания сессии
        app.post(NamedRoutes.loginPath(), SessionsController::login);
        //POST /sessions/delete для удаления сессии
        app.post(NamedRoutes.logoutPath(), SessionsController::logout);

        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
