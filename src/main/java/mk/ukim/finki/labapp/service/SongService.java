package mk.ukim.finki.labapp.service;

import mk.ukim.finki.labapp.model.Artist;
import mk.ukim.finki.labapp.model.Song;

import java.util.List;

public interface SongService{
    List<Song> listSongs();
    void addArtistToSong(Artist artist, Song song); //Zoshto vrakja Artist a ne void?
    public Song findByTrackId(String trackId);
}