@import gg.jte.Content
@param Content content

<!doctype html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>Hexlet pet project</title>
</head>
<body>
    <div class="container">
        <header class="d-flex justify-content-center .py-3">
            <ul class="nav nav-pills">
                <button type="button" class="btn btn-link"><a href="/">Main page</a></button>
                <button type="button" class="btn btn-link"><a href="/users">Users</a></button>
            </ul>
        </header>
    </div>
    ${content}
    <div class="container">
        <footer class="py-3 my-4">
            <p class="text-center text-muted"><a href="https://github.com/d1z3d">Github</a></p>
        </footer>
    </div>
</body>
</html>
