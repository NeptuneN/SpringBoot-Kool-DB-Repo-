package ee.kool.kool.movies.service;

import ee.kool.kool.actors.dto.Actor;
import ee.kool.kool.movies.dto.Film;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    public List<Film> mockMovies() {
        List<Film> films = new ArrayList<>();
        Film movie1 = new Film();
        movie1.setId(movie1.getId());
        movie1.setName("Star Wars");
        Actor actor1 = new Actor();
        actor1.setForeName("Matthew");
        actor1.setLastName("Mercer");
        actor1.setId(actor1.getId());

        List<Actor> actors = new ArrayList<>();
        actors.add(actor1);
        movie1.setActors(actors);
        films.add(movie1);
        return films;
    }

    public Film mockOneMovie(Integer id) {
        Film movie2 = new Film();
        movie2.setId(movie2.getId());
        movie2.setName("Overwatch");
        return movie2;
    }
}
