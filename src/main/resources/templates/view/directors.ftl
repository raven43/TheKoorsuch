<#import "../parts/common.ftl" as c>
<#import "../parts/navbar.ftl" as n>

<@c.page "Режиссёры">

    <#--TODO: fix dir list-->

    <div>
        <#list directors as director>
        <div class="row border rounded bg-light m-1 p-1">
            <div class="col-2">
                <img class="img-fluid" src="${director.imageURL?if_exists}">
            </div>
            <div class="col-8">
                <h5><a href="/director?id=${director.id}">${director.name?if_exists}</a></h5>
                <h6 class="card-subtitle mb-2 text-muted">${director.birth?if_exists}</h6>
                <ul class="list-inline">
                    <#list director.films as film>
                    <li class="list-inline-item">${film.name}</li>
                    </#list>
                </ul>

            </div>
            <div class="col-2">
                <form method="post">
                    <input type="hidden" value="${director.id}" name="delete">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <button class="btn btn-danger">delete</button>
                </form>
                <a class="btn btn-info" href="/edit/director?id=${director.id}">edit</a>
            </div>
        </div>
        </#list>
    </div>
</@c.page>