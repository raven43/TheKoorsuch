package app.repository;

import app.entities.Director;
import app.entities.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface DirectorRepository extends CrudRepository<Director,Integer> {

    Director getDirectorById(Integer id);
    Set<Director> findByNameContains(String s);

}
