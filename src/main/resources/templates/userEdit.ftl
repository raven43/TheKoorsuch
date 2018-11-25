<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>

<@c.page "User editor: ${user.username}">

    <form class="container" action="/user" method="post">
        <input type="text" name="username" value="${user.username}">
        <#list roles as r>
        <div>
            <label>
                <input type="checkbox" name="${r}" ${(user.roles)?seq_contains(r)?string("checked","")}>${r}
            </label>
        </div>
        </#list>

        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="hidden" name="userId" value="${user.id}">
        <button class="btn btn-info" type="submit"> Save </button>
    </form>

</@c.page>