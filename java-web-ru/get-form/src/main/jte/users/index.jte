@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(content = @`
    @if(page.getTerm() != null)
        <form action="/users" method="get">
            <input type="search" name="term" value="${page.getTerm()}" />
            <input type="submit" value="Search" />
        </form>


    @else
        <form action="/users" method="get">
            <input type="search" name="term" value="" />
            <input type="submit" value="Search" />
        </form>
    @endif

    <div>
        @for(var user : page.getUsers())
            <p>${user.getFirstName()} ${user.getLastName()}</p>
        @endfor
    </div>
`)