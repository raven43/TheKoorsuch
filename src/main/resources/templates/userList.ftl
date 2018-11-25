<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>

<@c.page "User List">


    <h2>List if users</h2>
    <table class="table table-striped table-bordered">
        <thead class="table-info">
            <tr>
                <td>Name</td>
                <td>Roles</td>
                <td></td>
            </tr>
        </thead>
        <tbody>
            <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="user/${user.id}">edit</a> </td>
            </tr>
            </#list>
        </tbody>
    </table>

</@c.page>