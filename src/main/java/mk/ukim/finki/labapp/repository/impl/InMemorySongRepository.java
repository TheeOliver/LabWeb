package mk.ukim.finki.labapp.repository.impl;

import mk.ukim.finki.labapp.bootstrap.DataHolder;
import mk.ukim.finki.labapp.model.Artist;
import mk.ukim.finki.labapp.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemorySongRepository {
    public List<Song> findAll() {
        return DataHolder.songs;
    }

    public Song findByTrackId(String trackId) {
        return DataHolder.songs.stream().filter(x -> x.getTrackId().equals(trackId)).findFirst().orElse(null);
    }

    public Song findBySongId(Long id) {
        return DataHolder.songs.stream().filter(x->x.getId().equals(id)).findFirst().orElse(null);
    }

    public int findIndexById(Long id) {
        for (int i = 0; i < DataHolder.songs.size(); i++) {
            if (DataHolder.songs.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void addArtistToSong(Artist artist, Song song) {
        findByTrackId(song.getTrackId()).getArtists().add(artist);
    }

    public void deleteSong(Long id) {
        DataHolder.songs.removeIf(x->x.getId().equals(id));
    }

    public void saveSong(Song song) {
        int idx = findIndexById(song.getId());
        if(idx == -1) {
            DataHolder.songs.add(song);
        }
        else {
            DataHolder.songs.set(idx, song);
        }
    }


}
