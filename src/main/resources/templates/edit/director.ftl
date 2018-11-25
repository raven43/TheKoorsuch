<#import "../parts/common.ftl" as c>
<#import "../parts/navbar.ftl" as n>

<@c.page "Director editor: ${director.name}">
    <h5><a href="/director?id=${director.id}">${message?if_exists}</a> </h5>
    <form class="row" action="/edit/director" method="post">
        <div class="col-4">
            <img class="rounded img-fluid" src="${director.imageURL?if_exists}">
            <input class="form-control" type="url" name="imageURL" value="${director.imageURL?if_exists}">
        </div>
        <div class="col-8">
            <input class="form-control m-1" type="text" name="name" value="${director.name}" placeholder="Имя">
            <input class="form-control m-1" type="date" name="birth" value="${director.b}">
            <textarea class="form-control m-1" name="description" placeholder="description" rows="6">${director.description}</textarea>
            <div class="form-group m-1">
            <#list films as f>
                <div class="form-check">
                    <input class="form-check-input mx-1" type="checkbox" id="f${f.id}"
                           name="f${f.id}" ${(director.films)?seq_contains(f)?string("checked","")}>
                    <label class="form-check-label" for="f${f.id}">
                        ${f.name}(${f.prodYear})
                    </label>
                </div>
            </#list>
            </div>

            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <input type="hidden" name="dirid" value="${director.id}">
            <button class="btn btn-info m-2" type="submit"> Save</button>
        </div>
    </form>

</@c.page>