package ee.kool.kool.movies.controller;

import ee.kool.kool.movies.dto.Film;
import ee.kool.kool.movies.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class FilmsController {

    @Autowired
    MovieService movieService;

    @GetMapping("/v1/films")
    List<Film> all() {
        log.info("ble");
        return movieService.mockMovies();
    }

    @GetMapping("v1/films/{id}")
    Film one(@PathVariable Integer id) {
        return movieService.mockOneMovie(id);
    }

}
