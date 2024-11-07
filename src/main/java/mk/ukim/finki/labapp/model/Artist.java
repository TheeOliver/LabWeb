package mk.ukim.finki.labapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Artist {
    private long id;
    private String firstName;
    private String lastName;
    private String bio;
}
