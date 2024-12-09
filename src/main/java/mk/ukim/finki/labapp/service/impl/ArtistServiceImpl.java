package mk.ukim.finki.labapp.service.impl;

import mk.ukim.finki.labapp.model.Artist;
import mk.ukim.finki.labapp.model.Song;
import mk.ukim.finki.labapp.repository.jpa.ArtistRepository;
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
    public Optional<Artist> findById(Long id) {
        return artistRepository.findById(id);
    }

    @Override
    public void addSongToArtist(Artist artist, Song song) {
        artist.getSongs().add(song);
        artistRepository.save(artist);
    }

    @Override
    public void removeSongFromArtists(Long id) {
        artistRepository.findAll().forEach(artist -> {
            artist.getSongs().removeIf(song -> song.getId().equals(id));
            artistRepository.save(artist);
        });
    }
}
