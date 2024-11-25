package mk.ukim.finki.labapp.service;

import mk.ukim.finki.labapp.model.Album;
import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> findAll();
    Optional<Album> findById(Long id);
}
