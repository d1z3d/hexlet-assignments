@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage mainPage

@template.layout.page(content = @`
    @if(mainPage.getUser() == null)
        <h3>
            <a href="${exercise.util.NamedRoutes.buildSessionPath()}">Войти</a>
        </h3>
    @else
        <p>${mainPage.getUser().getName()}</p>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти" />
        </form>
    @endif
`)