package ee.kool.kool.database;

import ee.kool.kool.actors.dto.Actor;
import ee.kool.kool.movies.dto.Film;
import ee.kool.kool.repositories.ActorRepository;
import ee.kool.kool.repositories.FilmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(FilmRepository filmRepository) {
        return args -> {
            log.info("Processing " + filmRepository.save(new Film(1L, "Overwatch", null)));
            log.info("Processing " + filmRepository.save(new Film(2L, "Firewatch", null)));
        };
    }

    @Bean
    CommandLineRunner initDatabase(ActorRepository actorRepository) {
        return args -> {
            log.info("Processing " + actorRepository.save(new Actor(1L, "Matthew", "Mercer", null)));
            log.info("Processing " + actorRepository.save((new Actor(2L, "Stacy", "Jule", null))));
        };
    }
}
