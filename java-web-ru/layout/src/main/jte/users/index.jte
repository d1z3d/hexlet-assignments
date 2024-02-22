@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
    <h1>Users</h1>
    @if(page.getUsers().isEmpty())
        <p>Users not found</p>
    @else
        <table class="table">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">Name</th>
                <th scope="col">LastName</th>
                <th scope="col">Email</th>
                <th scope="col">Link</th>
            </tr>
            </thead>
            <tbody>
            @for(var user : page.getUsers())
                <tr>
                    <th scope="row">${user.getId()}</th>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                    <td><a href="/users/${user.getId()}">Link</a></td>
                </tr>
            @endfor
            </tbody>
        </table>
    @endif
    `
)