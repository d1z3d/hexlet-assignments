package exercise.controller;

import java.util.Collections;

import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", Collections.singletonMap("page", page));
    }

    // BEGIN
    public static void create(Context context) {
        try {
            var name = context.formParamAsClass("name", String.class)
                    .check(x -> x.length() >= 2, "Название статьи должно быть больше 2 символов")
                    .get();
            var body = context.formParam("body");
            var post = new Post(name, body);
            PostRepository.save(post);
            context.sessionAttribute("flash", "Пост был успешно создан!");
            context.redirect(NamedRoutes.postsPath());
        } catch (ValidationException e) {
            var name = context.formParam("name");
            var body = context.formParam("body");
            var page = new BuildPostPage(name, body, e.getErrors());
            context.render("posts/build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void index(Context context) {
        var posts = PostRepository.getEntities();
        var page = new PostsPage(posts);
        page.setFlash(context.consumeSessionAttribute("flash"));
        context.render("posts/index.jte", Collections.singletonMap("page", page));
    }
    // END

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
}
