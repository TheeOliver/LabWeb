package mk.ukim.finki.labapp.service;

import mk.ukim.finki.labapp.model.Album;
import mk.ukim.finki.labapp.model.Artist;
import mk.ukim.finki.labapp.model.Song;

import java.util.List;

public interface SongService{
    List<Song> listSongs();
    void addArtistToSong(Artist artist, Song song);
    Song findByTrackId(String trackId);
    void deleteById(Long id);
    void addNewSong(String title,
                        String trackId,
                        String genre,
                        int releaseYear,
                        Album album);
    void editSong(Long songId,
                  String title,
                  String trackId,
                  String genre,
                  int releaseYear,
                  Album album);
    Song findBySongId(Long id);
}