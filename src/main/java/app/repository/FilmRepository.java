package app.repository;

import app.entities.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface FilmRepository extends CrudRepository<Film,Integer> {

    List<Film> findByTag(String tag);
    Film getFilmById(Integer id);
    void deleteById(Integer id);

    Iterable<Film> getByProdYearBetween(short from, short to);
    Set<Film> findByNameIsContaining(String s);



}