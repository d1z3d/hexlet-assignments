@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
    page = page,
    content = @`
    <a href="posts/build">Создать пост</a>
    @if(!page.getPosts().isEmpty())
        <div>
            @for(var post : page.getPosts())
                <h3>${post.getName()}</h3>
                <p>${post.getBody()}</p>
            @endfor
        </div>
    @endif
`)
