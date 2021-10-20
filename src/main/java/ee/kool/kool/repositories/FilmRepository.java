package ee.kool.kool.repositories;

import ee.kool.kool.movies.dto.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
