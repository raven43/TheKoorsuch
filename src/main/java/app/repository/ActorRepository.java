package app.repository;

import app.entities.Actor;
import app.entities.Film;
import org.springframework.data.repository.CrudRepository;

import java.util.Set;

public interface ActorRepository extends CrudRepository<Actor,Integer> {
    Actor getActorById(Integer id);
    Set<Actor> findByNameContains(String s);
}
