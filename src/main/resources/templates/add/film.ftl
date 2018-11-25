<#import "../parts/common.ftl" as c>
<#import "../parts/navbar.ftl" as n>

<@c.page "Edit">
    <h1>Добавление фильма</h1>
    <h5><a href="/film?id=${id?if_exists}">${message?if_exists}</a></h5>
    <form method="post">
        <div class="form-row">
            <div class="form-group col">
                <input class="form-control" name="name" type="text" placeholder="Название">
            </div>
            <div class="form-group col">
                <input class="form-control form-group" name="altName" type="text" placeholder="Оригинальное название">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-2">
                <input name="prodYear" type="number" min="1960" max="2020" class="form-control" placeholder="Год">
            </div>
            <div class="form-group col-md-5">
                <input name="imageURL" type="url" class="form-control" placeholder="Картиночка">

            </div>
        </div>
        <div class="form-row">
            <#list genres as g>
            <div class="form-check form-check-inline">
                <input class="form-check-input" type="checkbox" id="g${g}" name="${g}">
                <label class="form-check-label" for="g${g}">${g.str}</label>
            </div>
            </#list>
        </div>
        <#--TODO:fix size-->
        <div class="form-row">
            <div class="form-group">
                <input class="input-group" type="text" name="description">
            </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit" class="btn btn-primary">Добавить</button>
    </form>

</@c.page>