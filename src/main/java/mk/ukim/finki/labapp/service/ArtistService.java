package mk.ukim.finki.labapp.service;

import mk.ukim.finki.labapp.model.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService{
    List<Artist> listArtists();
    Optional<Artist> findById(Long id);
}
