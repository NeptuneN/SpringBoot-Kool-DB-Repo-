package ee.kool.kool.movies.dto;

import ee.kool.kool.actors.dto.Actor;
import lombok.Data;
import java.util.List;
@Data
public class Film {
    private int id;
    private String name;
    private List<Actor> actors;
}
