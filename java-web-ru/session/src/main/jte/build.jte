@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage loginPage

@template.layout.page(content = @`
    <div>
        @if(loginPage != null && !loginPage.getError().isEmpty())
            <ul>
                <li>${loginPage.getError()}</li>
            </ul>
        @endif
    </div>

    <div>
        <form action="${NamedRoutes.loginPath()}" method="post">
            <div>
                <label>
                    Имя
                    <input type="text" name="name" value="${loginPage != null ? loginPage.getName() : ""}"/>
                </label>
            </div>

            <div>
                <label>
                    Пароль
                    <input type="password" name="password" />
                </label>
            </div>
            <input type="submit" value="Войти">
        </form>
    </div>
`)
