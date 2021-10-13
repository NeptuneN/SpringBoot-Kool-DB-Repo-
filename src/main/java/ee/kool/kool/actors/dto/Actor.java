package ee.kool.kool.actors.dto;

import ee.kool.kool.movies.dto.Film;
import lombok.Data;

import java.util.List;

@Data
public class Actor {
    private int id;
    private String foreName;
    private String lastName;
    private List<Film> films;
}
