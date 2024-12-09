package mk.ukim.finki.labapp.repository.impl;

import mk.ukim.finki.labapp.bootstrap.DataHolder;
import mk.ukim.finki.labapp.model.Artist;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryArtistRepository {
    public List<Artist> findAll() {
        return DataHolder.artists;
    }

    public Optional<Artist> findById(Long id) { //Problem koga vrakjav Optional
        return DataHolder.artists.stream().filter(x->x.getId() == id).findFirst();
    }
}
