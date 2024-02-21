package exercise;

import io.javalin.Javalin;

import static exercise.Data.getDomains;
import static exercise.Data.getPhones;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        var app = Javalin.create();
        app.get("/phones", context -> context.json(getPhones()));
        app.get("/domains", context -> context.json(getDomains()));
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
