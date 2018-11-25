<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page "Register">
    ${message?if_exists}
    <@l.login "/register" "Register" false/>
</@c.page>