<#import "../parts/common.ftl" as c>
<#import "../parts/navbar.ftl" as n>
<@c.page "${actor.name}">


    <div class="row">
        <div class="col4">
            <img class="rounded" src="${actor.imageURL}">
        </div>
        <div class="col-8">
            <h3>${actor.name}</h3>
            <p class="text-muted">${actor.birth}</p>
            <p>${actor.description}</p>
            <ul class="list-group">
                <#list actor.films as film>
                    <li class="list-group-item"><b>${film.prodYear}</b> <a href="/film?id=${film.id}"> ${film.name}</a></li>
                </#list>
            </ul>
        </div>
    </div>





    <form class="form-row mt-5" method="post">
        <select class="form-group custom-select form-inline" name="filmid">
            <option class="form-control" disabled>Фильм</option>

            <#list films as film>
            <option class="form-control" value="${film.id}">${film.name} (${film.y})</option>
            </#list>
        </select>
        <input type="hidden" name="actorid" value="${actor.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-info form-inline" type="submit"> Добавить фильм</button>
    </form>
</@c.page>