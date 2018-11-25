<#import "../parts/common.ftl" as c>
<#import "../parts/navbar.ftl" as n>

<@c.page "Films">
    <h1 class="h1 header">List of Films</h1>

<#--TODO: search bar-->
<#--TODO: fix list-->

    <form class="form-row" action="/films" method="get">
        <div class="form-group form-inline col-2">
            <input class="form-control" type="number" id="yearFrom" name="yearFrom">
            <label for="yearFrom">от</label>
        </div>
        <div class="form-group form-inline col-2">
            <input class="form-control" type="number" id="yearTo" name="yearTo">
            <label for="yearTo">до</label>
        </div>
        <button class="btn btn-primary form-inline" type="submit">Поиск</button>
    </form>
    <div>
        <#list films as film>
            <div class="row border-primary rounded m-1 p-1">
                <div class="col-2">
                    <img class="img-fluid" src="${film.imageURL?if_exists}">
                </div>
                <div class="col-8">
                    <a href="/film?id=${film.id}"><h5>${film.name?if_exists}</h5></a>
                    <h6 class="card-subtitle mb-2 text-muted">${film.y?if_exists} ${film.altName?if_exists}</h6>
                    <#if (film.director)??>
                        <a class="searchTagLink" href="/director?id=${film.director.id}">
                            ${film.director.name}
                        </a>
                    </#if>
                    <ul class="list-inline">
                    <#list film.genres as genre>
                        <li class="list-inline-item">${genre.str}</li></#list>
                    </ul>

                </div>
                <div class="col-2">
                    <form method="post">
                        <input type="hidden" value="${film.id}" name="delete">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button class="btn btn-danger" type="submit">delete</button>
                    </form>
                    <a class="btn btn-info" href="/edit/film?id=${film.id}">edit</a>
                </div>
            </div>
        </#list>
    </div>

</@c.page>


