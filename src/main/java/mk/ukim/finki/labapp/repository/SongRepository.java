package mk.ukim.finki.labapp.repository;

import mk.ukim.finki.labapp.bootstrap.DataHolder;
import mk.ukim.finki.labapp.model.Artist;
import mk.ukim.finki.labapp.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SongRepository {
    public List<Song> findAll() {
        return DataHolder.songs;
    }

    public Song findByTrackId(String trackId) {
        return DataHolder.songs.stream().filter(x -> x.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    public void addArtistToSong(Artist artist, Song song) { //Zoshto vrakja Artist?
        DataHolder.songs.stream().filter(x-> x.getTrackId().equals(song.getTrackId())).findFirst().ifPresent(x->{x.getPerformers().add(artist);});
    } //Zoshto e ova addArtistToSong?
}
