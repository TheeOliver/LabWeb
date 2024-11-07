package mk.ukim.finki.labapp.service.impl;

import mk.ukim.finki.labapp.model.Artist;
import mk.ukim.finki.labapp.repository.ArtistRepository;
import mk.ukim.finki.labapp.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistServiceImpl implements ArtistService {
    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        return artistRepository.findAll();
    }

    @Override
    public Artist findById(Long id) { //Vrakjashe Artist po baranjeto no imav erori
        return artistRepository.findById(id);
    }
}
