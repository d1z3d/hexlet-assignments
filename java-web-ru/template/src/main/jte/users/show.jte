@import exercise.dto.users.UserPage
@param UserPage userPage

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Пользователь</title>
</head>
<body>
    <main>
        <h1>Пользователь</h1>
        <p>ID - ${userPage.getUser().getId()}</p>
        <p>${userPage.getUser().getFirstName()} ${userPage.getUser().getLastName()}</p>
    </main>
</body>
</html>
