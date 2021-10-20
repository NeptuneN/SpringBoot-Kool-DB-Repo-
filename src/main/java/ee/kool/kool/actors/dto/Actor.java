package ee.kool.kool.actors.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ee.kool.kool.movies.dto.Film;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    private String foreName;
    private String lastName;
    @JsonIgnoreProperties("actors")
    @ManyToMany(mappedBy = "actors") List<Film> films = new ArrayList<>();

    public Actor (int id, String foreName, String lastName, List<Actor> actors) {
        this.id = id;
        this.foreName = foreName;
        this.lastName = lastName;
        this.films = films;
    }

    public Actor () {

    }

    // Delete everything above to fix

    /*private int id;
    private String foreName;
    private String lastName;
    private List<Film> films;*/
}
