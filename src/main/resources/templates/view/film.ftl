<#import "../parts/common.ftl" as c>
<#import "../parts/navbar.ftl" as n>

<@c.page "${film.name}">


    <div class="row">
        <div class="col4">
            <img class="rounded" src="${film.imageURL?if_exists}">
        </div>
        <div class="col-8">
            <h3>${film.name}</h3>
            <p class="text-muted">${film.altName?if_exists}</p>
            <p class="text-muted">${film.y}</p>
            <ul class="list-inline">
                <#list film.genres as genre><li class="list-inline-item">${genre.str}</li><#sep>, </#list>
            </ul>
            <#if (film.director)??><a class="searchTagLink" href="/director?id=${film.director.id}">${film.director.name}</a></#if>
            <p>${film.description?if_exists}</p>
            <ul class="list-group">
                <#list film.actors as a>
                    <li class="list-group-item"><a href="/actor?id=${a.id}"> ${a.name}</a></li>
                </#list>
            </ul>
        </div>
    </div>
</@c.page>