<#import "../parts/common.ftl" as c>
<#import "../parts/navbar.ftl" as n>

<@c.page "Актеры">

    <div class="row">
    <#list actors as actor>
        <div class="col-3">
            <div class="card" >
                <img class="card-img-top" src="${actor.imageURL?if_exists}" alt="Card image cap">
                <div class="card-body p-1">
                    <a href="/actor?id=${actor.id}"><h5 class="card-title">${actor.name}</h5></a>
                    <p class="card-text card-subtitle m-1">${actor.birth}</p>
                    <ul class="list-group list-group-flush">
                    <#list actor.films as film>
                        <li class="list-group-item"><a href="/film?id=${film.id}">${film.name}(${film.y})</a></li>
                    </#list>
                    </ul>
                </div>
                <div class="form-inline">
                    <a class="btn btn-info mr-1" href="/edit/actor?id=${actor.id}">edit</a>
                    <form method="post">
                        <input type="hidden" value="${actor.id}" name="delete">
                        <input type="hidden" name="_csrf" value="${_csrf.token}">
                        <button class="btn btn-danger ml-1" type="submit">delete</button>
                    </form>
                </div>
            </div>
        </div>

    </#list>
    </div>

</@c.page>
