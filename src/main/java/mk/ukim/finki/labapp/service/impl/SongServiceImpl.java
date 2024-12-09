package mk.ukim.finki.labapp.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.labapp.model.Album;
import mk.ukim.finki.labapp.model.Artist;
import mk.ukim.finki.labapp.model.Song;
import mk.ukim.finki.labapp.model.exceptions.InvalidArgumentsException;
import mk.ukim.finki.labapp.model.exceptions.SongNotFoundException;
import mk.ukim.finki.labapp.repository.jpa.SongRepository;
import mk.ukim.finki.labapp.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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
    public void addArtistToSong(Artist artist, Song song) {
        List<Artist> artists = song.getArtists();
        artists.add(artist);
        song.setArtists(artists);
        songRepository.save(song);
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    public Song findBySongId(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteSongById(Long id) {
        if(id == null) {
            throw new SongNotFoundException(id);
        }
        songRepository.deleteById(id);
    }

    @Override
    public void addNewSong(String title, String trackId, String genre, int releaseYear, Album album) {
        if(title == null || title.isEmpty()
        || trackId == null || trackId.isEmpty()
        || genre == null || genre.isEmpty() || album == null) {
            throw new InvalidArgumentsException();
        }

        songRepository.save(new Song(trackId, title, genre, releaseYear, album));
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
        songRepository.save(editedSong);
    }
}
