@import exercise.dto.posts.EditPostPage
@import exercise.util.NamedRoutes
@param EditPostPage editPostPage

@template.layout.page(content = @`
    @if(editPostPage.getErrors() != null)
        <div class="mb-3">
            <ul>
                @for(var validator : editPostPage.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        </div>
    @endif

    <div class="mx-auto p-4 py-md-5">
        <form action="${NamedRoutes.postPath(editPostPage.getPost().getId())}" method="post">
            <div class="mb-3">
                <label class="form-label">
                    Название
                    <input type="text" class="form-control" name="name" value="${editPostPage.getPost().getName()}" />
                </label>
            </div>
            <div class="mb-3">
                <label class="form-label">Содержание</label>
                <textarea class="form-control" rows="20" cols="70" type="text" name="body">${editPostPage.getPost().getBody()}</textarea>
            </div>
            <input type="submit" class="btn btn-primary" value="Обновить" />
        </form>
    </div>
`)