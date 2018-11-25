package app.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private Date birth;
    private String imageURL;
    private String description;
    public Director(){}

    public Director(String name, Date birth, String description, String imageURL) {
        this.name = name;
        this.birth = birth;
        this.imageURL = imageURL;
        this.description = description;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Film> films;

    @Override
    public String toString() {
        return "Director{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", imageURL='" + imageURL + '\'' +
                ", films=" + films +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public String getB() {
        return birth.toString();
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public void addFilm(Film film) {
        this.films.add(film);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
