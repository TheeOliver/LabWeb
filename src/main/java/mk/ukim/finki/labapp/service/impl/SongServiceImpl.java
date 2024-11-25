package mk.ukim.finki.labapp.service.impl;

import mk.ukim.finki.labapp.model.Album;
import mk.ukim.finki.labapp.model.Artist;
import mk.ukim.finki.labapp.model.Song;
import mk.ukim.finki.labapp.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.labapp.model.exceptions.SongNotFoundException;
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

    public Song findBySongId(Long id) {
        return songRepository.findBySongId(id);
    }

    @Override
    public void deleteById(Long id) {
        if(id == null) {
            throw new SongNotFoundException(id);
        }
        songRepository.deleteSong(id);
    }

    @Override
    public void addNewSong(String title, String trackId, String genre, int releaseYear, Album album) {
        if(title == null || title.isEmpty()
        || trackId == null || trackId.isEmpty()
        || genre == null || genre.isEmpty() || album == null) {
            throw new InvalidArgumentsException();
        }

        songRepository.saveSong(new Song(trackId, title, genre, releaseYear, album));
    }

    @Override
    public void editSong(Long songId, String title, String trackId, String genre, int releaseYear, Album album) {
        if(songId == null
        || title == null || title.isEmpty()
        || trackId == null || trackId.isEmpty()
        || genre == null || genre.isEmpty() || album == null) {
            throw new InvalidArgumentsException();
        }

        Song editedSong = findBySongId(songId);
        editedSong.setTitle(title);
        editedSong.setTrackId(trackId);
        editedSong.setGenre(genre);
        editedSong.setReleaseYear(releaseYear);
        editedSong.setAlbum(album);
        songRepository.saveSong(editedSong);
    }
}
