@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(content = @`
    <div>
        @if(!page.getPosts().isEmpty())
            @for(var i = page.getPagination() * 5 - 5; i < page.getPagination() * 5; i++)
                <h5>
                    <a href="${NamedRoutes.postPath(page.getPosts().get(i).getId())}">${page.getPosts().get(i).getName()}</a>
                </h5>
            @endfor
        @endif
        <hr>
        <p>Pages</p>
        @if(page.getPagination() == 1)
            <span>
                <a href="/posts?pagination=${page.getPagination() + 1}">Вперед</a>
            </span>
        @elseif(page.getPagination() == Double.valueOf(Math.ceil(page.getPosts().size() / 5)).intValue() - 1)
            <span>
                <a href="/posts?pagination=${page.getPagination() - 1}">Назад</a>
            </span>
        @else
            <span>
                <a href="/posts?pagination=${page.getPagination() - 1}">Назад</a>
            </span>
            <span> </span>
            <span>
                <a href="/posts?pagination=${page.getPagination() + 1}">Вперед</a>
            </span>
        @endif
    </div>
`)
