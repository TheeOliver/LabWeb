package mk.ukim.finki.labapp.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SongNotFoundException extends RuntimeException {
    public SongNotFoundException(Long id) {
        super(String.format("Song with id: %d was not found", id));
    }
}
