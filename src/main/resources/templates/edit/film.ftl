<#import "../parts/common.ftl" as c>
<#import "../parts/navbar.ftl" as n>

<@c.page "Film editor: ${film.name}">

    <h5><a href="/film?id=${film.id}">${message?if_exists}</a> </h5>
    <form class="row" action="/edit/film" method="post">
        <div class="col-4">
            <img class="rounded" src="${film.imageURL?if_exists}">
            <input class="form-control" type="url" name="imageURL" value="${film.imageURL?if_exists}">
        </div>
        <div class="col-8">
            <input class="form-control m-1" type="text" name="name" value="${film.name}" placeholder="Название">
            <input class="form-control m-1" type="text" name="altName" value="${film.altName}" placeholder="Оригинальное название">
            <input class="form-control m-1" type="number" min="1960" max="2020" name="prodYear" value="${film.y}">
            <input class="form-control m-1" type="text" name="description" value="${film.description}" placeholder="description">
            <ul class="list-group m-2">
            <#list genres as g>
                <li class="list-group-item">
                    <input class="form-check-input" type="checkbox" name="${g}" ${(film.genres)?seq_contains(g)?string("checked","")}>
                    ${g.str}
                </li>
            </#list>
            </ul>
            <ul class="list-group my-2">
            <#list actors as a>
                <li class="list-group-item">
                    <input class="form-check-input" type="checkbox" name="${a.name}" ${(film.actors)?seq_contains(a)?string("checked","")}>
                    ${a.name}
                </li>
            </#list>
            </ul>
            <ul class="list-group m-2">
            <#list directors as d>
                <li class="list-group-item">
                    <input class="custom-radio" type="radio" name="${d.name}" ${(film.director==d)?string("checked","")}>
                    ${d.name}
                </li>
            </#list>
            </ul>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="hidden" name="filmid" value="${film.id}">
            <button class="btn btn-info m-2" type="submit"> Save </button>
        </div>
    </form>

</@c.page>