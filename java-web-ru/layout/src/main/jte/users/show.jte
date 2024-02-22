@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(content = @`
    <h1>Пользователь</h1>
    <p>ID - ${page.getUser().getId()}</p>
    <p>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</p>
`)
