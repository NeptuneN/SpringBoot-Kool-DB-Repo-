package ee.kool.kool.repositories;

import ee.kool.kool.actors.dto.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {

}
