package mk.ukim.finki.labapp.service.impl;

import mk.ukim.finki.labapp.model.Artist;
import mk.ukim.finki.labapp.model.Song;
import mk.ukim.finki.labapp.repository.SongRepository;
import mk.ukim.finki.labapp.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {
    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }


    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public void addArtistToSong(Artist artist, Song song) { //Zoshto vrakja Artist?
        songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }
}
