<#import "../parts/common.ftl" as c>
<#import "../parts/navbar.ftl" as n>

<@c.page "Добавление режиссёра">
    <h1>Добавление режиссёра</h1>
    <h5><a href="/director?id=${id?if_exists}">${message?if_exists}</a></h5>
    <form method="post">
        <div class="form-row">
            <div class="form-group col">
                <input class="form-control" name="name" type="text" placeholder="Имя">
            </div>
            <div class="form-group col">
                <input class="form-control " name="birth" type="date">
            </div>
            <div class="form-group col">
                <input class="form-control" name="imageURL" type="url" placeholder="Картиночка">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col">
                <input class="form-control" name="description" type="text" placeholder="Описание">
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary">Добавить</button>
    </form>

</@c.page>