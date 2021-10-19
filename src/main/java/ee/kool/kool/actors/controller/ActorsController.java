package ee.kool.kool.actors.controller;

import ee.kool.kool.actors.dto.Actor;
import ee.kool.kool.actors.service.ActorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ActorsController {

    @Autowired
    ActorService actorService;

    @GetMapping("/v1/actors")
    List<Actor> all() {
        log.info("elb");
        return actorService.mockActors();
    }

    @GetMapping("/v1/actors/{id}")
    Actor one(@PathVariable Integer id) {
        return actorService.mockOneActor(id);
    }
}
