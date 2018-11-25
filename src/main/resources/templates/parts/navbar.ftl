<#include "security.ftl">
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
            aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="/">KOORSUCH.TV</a>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
        <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
            <li class="nav-item active">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/films">Films</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/directors">Directors</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/actors">Actors</a>
            </li>
            <#if isAdmin>
            <li class="nav-item">
                <a class="nav-link" href="/user">User list</a>
            </li>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navDd" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="fals nme">
                    Add/Edit
                </a>
                <div class="dropdown-menu" aria-labelledby="navDd">
                    <a class="dropdown-item" href="/add/film">Film add</a>
                    <a class="dropdown-item" href="/add/director">Dicector add</a>
                    <a class="dropdown-item" href="/add/actor">Actor add</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/edit">Edit</a>

                </div>
            </li>
            </#if>

        </ul>
        <form class="form-inline" method="get" action="/serch">
            <input class="form-control mr-sm-2" name="s" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
        <#if isAuthorize>
            <b class="navbar-text text-info mr-2 ml-2">${name}</b>

            <form class="form-inline my-2 my-lg-0" action="/logout" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Sign Out</button>
            </form>
        <#else>
            <div class="form-inline my-2 my-lg-0 mr-2">
                <a class="btn btn-outline-success my-2 my-sm-0" href="/login">Log in</a>
            </div>
            <div class="form-inline my-2 my-lg-0 mr-2">
                <a class="btn btn-outline-info my-2 my-sm-0" href="/register">Register</a>
            </div>
        </#if>

    </div>
</nav>

