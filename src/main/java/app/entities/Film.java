package app.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String altName;
    private short prodYear;
    private String description;
    private String imageURL;

    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    private Director director;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Actor> actors;

    @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "film_genres", joinColumns = @JoinColumn(name = "film_id"))
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres;

    public Film() {
    }


    public Film(String name, String altName, short prodYear,
                String description, String imageURL,
                User author, Director director
    ) {
        this.name = name;
        this.altName = altName;
        this.prodYear = prodYear;
        this.description = description;
        this.imageURL = imageURL;
        this.author = author;
        this.director = director;
    }

    public Film(String name, String altName, short prodYear, String description, String imageURL) {
        this.name = name;
        this.altName = altName;
        this.prodYear = prodYear;
        this.description = description;
        this.imageURL = imageURL;
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

    public short getProdYear() {
        return prodYear;
    }

    public String getY() {
        return String.valueOf(prodYear);
    }


    public void setProdYear(short prodYear) {
        this.prodYear = prodYear;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public String getAltName() {
        return altName;
    }

    public void setAltName(String altName) {
        this.altName = altName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
