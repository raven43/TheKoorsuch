package app.entities;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name = "usr")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String password;
    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Film> favFilms;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Actor> favActors;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Director> favDirectors;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return getUsername();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Film> getFavFilms() {
        return favFilms;
    }

    public void setFavFilms(Set<Film> favFilms) {
        this.favFilms = favFilms;
    }

    public Set<Actor> getFavActors() {
        return favActors;
    }

    public void setFavActors(Set<Actor> favActors) {
        this.favActors = favActors;
    }

    public Set<Director> getFavDirectors() {
        return favDirectors;
    }

    public void setFavDirectors(Set<Director> favDirectors) {
        this.favDirectors = favDirectors;
    }

    public boolean isAdmin(){
        return roles.contains(Role.ADMIN);
    }
}
