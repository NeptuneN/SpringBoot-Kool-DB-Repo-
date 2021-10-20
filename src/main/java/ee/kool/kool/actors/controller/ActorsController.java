package ee.kool.kool.actors.controller;

import ee.kool.kool.actors.dto.Actor;
import ee.kool.kool.actors.service.ActorService;
import ee.kool.kool.exceptions.ActorNotFoundException;
import ee.kool.kool.repositories.ActorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ActorsController {

    private final ActorRepository actorRepository;
    public ActorsController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Autowired
    ActorService actorService;

    @GetMapping("/v1/actors")
    List<Actor> all() {
        return actorRepository.findAll();
    }

    @PostMapping("/v1/actors")
    Actor newActor(@RequestBody Actor newActor) {
        return actorRepository.save(newActor);
    }

    @GetMapping("/v1/actors/{id}")
    Actor one(@PathVariable Long id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new ActorNotFoundException(id));
    }

    @PutMapping("/v1/actors/{id}")
    Actor newActor(@RequestBody Actor newActor, @PathVariable Long id) {

        return actorRepository.findById(id)
                .map(actor -> {
                    actor.setForeName(newActor.getForeName());
                    actor.setLastName((newActor.getLastName()));
                    actor.setFilms(newActor.getFilms());
                    return actorRepository.save(actor);
                })
                .orElseGet(() -> {
                   newActor.setId(id);
                   return actorRepository.save(newActor);
                });
    }

    @DeleteMapping("/v1/actors/{id}")
    void deleteActor(@PathVariable Long id) {
        actorRepository.deleteById(id);
    }

    /*@GetMapping("/v1/actors/{id}")
    Actor one(@PathVariable Integer id) {
        return actorService.mockOneActor(id);
    }*/
}
