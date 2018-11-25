<#macro login path name isLogin>

<#--TODO:   fix width-->

    <form class="col-4 m-auto align-content-center" action="${path}" method="post">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>

        <div class="form-group">
            <label for="exampleInputEmail1">Username</label>
            <input name="username" type="text" class="form-control" id="exampleInputEmail1" placeholder="Username">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}">

        <button type="submit" class="btn btn-primary mr-2" autofocus>${name}</button>
        <#if isLogin>
            <a href="/register"> Add new user</a>
        <#else>
            <a href="/login"> Log in</a>
        </#if>
    </form>


</#macro>