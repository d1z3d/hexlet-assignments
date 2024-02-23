package exercise;

import io.javalin.Javalin;
import io.javalin.http.HandlerType;
import io.javalin.http.HttpStatus;
import io.javalin.validation.ValidationError;
import io.javalin.validation.ValidationException;

import java.util.*;

import exercise.model.Article;
import exercise.dto.articles.ArticlesPage;
import exercise.dto.articles.BuildArticlePage;

import exercise.repository.ArticleRepository;

public final class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        app.get("/articles", ctx -> {
            List<Article> articles = ArticleRepository.getEntities();
            var page = new ArticlesPage(articles);
            ctx.render("articles/index.jte", Collections.singletonMap("page", page));
        });

        // BEGIN
        app.get("/articles/build", context -> {
            var page = new BuildArticlePage();
            context.render("articles/build.jte", Collections.singletonMap("page", page));
        });

        app.post("/articles", context -> {
            try {
                var title = context.formParam("title");
                var titleByRepo = ArticleRepository.findByTitle(title);


                var checkedTitle = context.formParamAsClass("title", String.class)
                        .check(x -> x.length() >= 2, "Название не должно быть короче двух символов")
                        .check(x -> titleByRepo.isEmpty(), "Статья с таким названием уже существует")
                        .get();

                var content = context.formParamAsClass("content", String.class)
                        .check(x -> x.length() >= 10, "Статья должна быть не короче 10 символов")
                        .get();


                var article = new Article(checkedTitle, content);
                ArticleRepository.save(article);
                context.redirect("/articles");
            } catch (ValidationException e) {
                var title = context.formParam("title");
                var content = context.formParam("content");
                var page = new BuildArticlePage(title, content, e.getErrors());
                context.status(422);
                context.render("articles/build.jte", Collections.singletonMap("page", page));
            }
        });
        // END

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
