package ee.kool.kool.actors.service;


import ee.kool.kool.actors.dto.Actor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

    public List<Actor> mockActors() {
        List<Actor> actors = new ArrayList<>();
        Actor actor1 = new Actor();
        actor1.setId(1);
        actor1.setForeName("");
        return actors;
    }

    public Actor mockOneActor(Integer id) {
        Actor actor2 = new Actor();
        actor2.setId(id);
        actor2.setForeName("Stacy");
        actor2.setLastName("Jule");
        return actor2;
    }
}
