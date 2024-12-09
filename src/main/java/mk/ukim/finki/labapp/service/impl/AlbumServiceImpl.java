package mk.ukim.finki.labapp.service.impl;

import mk.ukim.finki.labapp.model.Album;
import mk.ukim.finki.labapp.repository.jpa.AlbumRepository;
import mk.ukim.finki.labapp.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> findAll() {
        return albumRepository.findAll();
    }

    @Override
    public Optional<Album> findById(Long id) {
        return albumRepository.findById(id);
    }
}
