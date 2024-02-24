@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage postsPage

@template.layout.page(content = @`
    <div>
        @if(!postsPage.getPosts().isEmpty())
            @for(var i = postsPage.getPage() * 5 - 5; i < postsPage.getPage() * 5; i++)
                <h5>
                    <a href="${NamedRoutes.postPath(postsPage.getPosts().get(i).getId())}">${postsPage.getPosts().get(i).getName()}</a>
                </h5>
            @endfor
        @endif
        <hr>
        <p>Pages</p>
        @if(postsPage.getPage() == 1)
            <span>
                <a href="/posts?page=${postsPage.getPage() + 1}">Вперед</a>
            </span>
        @elseif(postsPage.getPage() == Double.valueOf(Math.ceil(postsPage.getPosts().size() / 5)).intValue() - 1)
            <span>
                <a href="/posts?page=${postsPage.getPage() - 1}">Назад</a>
            </span>
        @else
            <span>
                <a href="/posts?page=${postsPage.getPage() - 1}">Назад</a>
            </span>
            <span> </span>
            <span>
                <a href="/posts?page=${postsPage.getPage() + 1}">Вперед</a>
            </span>
        @endif
    </div>
`)
