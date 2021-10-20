package ee.kool.kool.movies.controller;

import ee.kool.kool.exceptions.FilmNotFoundException;
import ee.kool.kool.movies.dto.Film;
import ee.kool.kool.movies.service.MovieService;
import ee.kool.kool.repositories.FilmRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class FilmsController {

    private final FilmRepository filmRepository;
    public FilmsController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    @Autowired
    MovieService movieService;

    @GetMapping("/v1/films")
    List<Film> all() {
        return filmRepository.findAll();
    }

    @PostMapping("/v1/films")
    Film newFilm(@RequestBody Film newFilm) {
        return filmRepository.save(newFilm);
    }

    @GetMapping("/v1/films/{id}")
    Film one(@PathVariable Long id) {
        return filmRepository.findById(id)
                .orElseThrow(() -> new FilmNotFoundException(id));
    }

    @PutMapping("/v1/films/{id}")
    Film replaceFilm(@RequestBody Film newFilm, @PathVariable Long id) {

        return filmRepository.findById(id)
                .map(film -> {
                    film.setName(newFilm.getName());
                    film.setActors(newFilm.getActors());
                    return filmRepository.save(film);
                })
                .orElseGet(() -> {
                    newFilm.setId(id);
                    return filmRepository.save(newFilm);
                });
    }

    @DeleteMapping("/v1/films/{id}")
    void deleteFilm(@PathVariable Long id) {
        filmRepository.deleteById(id);
    }

    /*@GetMapping("/v1/films/{id}")
    Film one(@PathVariable Integer id) {
        return movieService.mockOneMovie(id);
    }*/
}
