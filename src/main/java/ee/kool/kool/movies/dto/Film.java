package ee.kool.kool.movies.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ee.kool.kool.actors.dto.Actor;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;
@Data
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
    private String name;
    @JsonIgnoreProperties("films")
    @ManyToMany(mappedBy = "films") List<Actor> actors = new ArrayList<>();

    public Film (int id, String name, List<Film> films) {
        this.id = id;
        this.name = name;
        this.actors = actors;
    }

    public Film () {

    }

    // Delete everything above to fix

    /*private int id;
    private String name;
    private List<Actor> actors;*/
}
