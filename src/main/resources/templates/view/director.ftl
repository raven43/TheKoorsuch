<#import "../parts/common.ftl" as c>
<#import "../parts/navbar.ftl" as n>

<@c.page "${director.name}">



    <div class="row">
        <div class="col4">
            <img class="img-fluid rounded" src="${director.imageURL}">
        </div>
        <div class="col-8">
            <h3>${director.name}</h3>
            <p class="text-muted">${director.birth}</p>
            <p>${director.description?if_exists}</p>
            <ul class="list-group">
                <#list director.films as film>
                    <li class="list-group-item"><b>${film.prodYear}</b> <a href="/film?id=${film.id}"> ${film.name}</a></li>
                </#list>
            </ul>
        </div>
    </div>

    <form class="form-row mt-5" method="post">
        <select class="form-group custom-select form-inline" name="filmid">
            <option class="form-control" disabled>Фильм</option>

        <#list films as film>
        <option class="form-control" value="${film.id}">${film.name} (${film.prodYear})</option>
        </#list>
        </select>
        <input type="hidden" name="dirid" value="${director.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button class="btn btn-info form-inline" type="submit"> Добавить фильм</button>
    </form>


</@c.page>