@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(content = @`
    <h1>
        <a href="${NamedRoutes.postsPath()}">Posts</a>
    </h1>
    <div>
        <h3>${page.getPost().getName()}</h3>
        <p>${page.getPost().getBody()}</p>
    </div>
`)
