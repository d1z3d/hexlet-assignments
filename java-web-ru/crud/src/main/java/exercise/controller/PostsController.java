package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context context) {
        var posts = PostRepository.getEntities();
        var page = context.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var postsPage = new PostsPage(posts, page);
        context.render("posts/index.jte", Collections.singletonMap("postsPage", postsPage));
    }

    public static void show(Context context) {
        var id = context.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Page not found"));
        var page = new PostPage(post);
        context.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    // END
}
