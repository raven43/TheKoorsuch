<#import "../parts/common.ftl" as c>
<#import "../parts/navbar.ftl" as n>

<@c.page "Actor editor: ${actor.name}">
    <h5><a href="/actor?id=${actor.id}">${message?if_exists}</a> </h5>
    <form class="row" action="/edit/actor" method="post">
        <div class="col-4">
            <img class="rounded img-fluid" src="${actor.imageURL?if_exists}">
            <input class="form-control" type="url" name="imageURL" value="${actor.imageURL?if_exists}">
        </div>
        <div class="col-8">
            <input class="form-control m-1" type="text" name="name" value="${actor.name}" placeholder="Имя">
            <input class="form-control m-1" type="date" name="birth" value="${actor.b}">
            <textarea class="form-control m-1" name="description" placeholder="description" rows="6">${actor.description}</textarea>
            <div class="form-group m-1">
            <#list films as f>
                <div class="form-check">
                    <input class="form-check-input mx-1" type="checkbox" id="f${f.id}"
                           name="f${f.id}" ${(actor.films)?seq_contains(f)?string("checked","")}>
                    <label class="form-check-label" for="f${f.id}">
                        ${f.name}(${f.prodYear})
                    </label>
                </div>
            </#list>
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="hidden" name="actid" value="${actor.id}">
            <button class="btn btn-info m-2" type="submit"> Save</button>
        </div>
    </form>

</@c.page>