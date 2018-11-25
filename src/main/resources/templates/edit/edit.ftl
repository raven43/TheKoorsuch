<#import "../parts/common.ftl" as c>
<#import "../parts/navbar.ftl" as n>

<@c.page "Edit">


    <div class="row">
        <div class="col-4">
            <h5>Films</h5>
            <ul class="list-group">
            <#list films as film><li class="list-group-item"><a href="/edit/film?id=${film.id}">${film.name}</a> </li></#list>
            </ul>
        </div>
        <div class="col-4">
            <h5>Actors</h5>
            <ul class="list-group">
            <#list actors as actor><li class="list-group-item"><a href="/edit/actor?id=${actor.id}">${actor.name}</a> </li></#list>
            </ul>
        </div>
        <div class="col-4">
            <h5>Directors</h5>
            <ul class="list-group">
            <#list directors as director><li class="list-group-item"><a href="/edit/director?id=${director.id}">${director.name}</a> </li></#list>
            </ul>
        </div>
    </div>

</@c.page>