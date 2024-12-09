package mk.ukim.finki.labapp.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.labapp.model.Album;
import mk.ukim.finki.labapp.model.Artist;
import mk.ukim.finki.labapp.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DataHolder {
    public static List<Artist> artists;
    public static List<Song> songs;
    public static List<Album> albums;

    @PostConstruct
    public void init(){
        artists = new ArrayList<>();
        artists.add(new Artist("Kiril", "Stefanovski", "Pop diva"));
        artists.add(new Artist("Luka", "Mihajlovski", "Raper"));
        artists.add(new Artist("Jana", "Angeloska", "Indie guitarist"));
        artists.add(new Artist("Rebeka", "Maneva", "Rock band vocalist"));
        artists.add(new Artist("Dimitri", "Petrovski", "Jazzzyy"));

        albums = new ArrayList<>();
        albums.add(new Album("sestra", "Hyperpop", "2024"));
        albums.add(new Album("freak", "Rap", "2019"));
        albums.add(new Album("Zivot kako magdonos", "Pop", "2014"));
        albums.add(new Album("APPA", "Metal", "2014"));
        albums.add(new Album("Brawling Star", "Jazz", "2017"));

        songs = new ArrayList<>();
        songs.add(new Song("track1", "39.2", "Hyperpop", 2024, artists.subList(0, 1), albums.get(0)));
        songs.add(new Song("track2", "30 Denari", "Rap", 2019, artists.subList(1, 2), albums.get(1)));
        songs.add(new Song("track3", "Od Jana verzijata", "Pop", 2014, artists.subList(2, 3), albums.get(2)));
        songs.add(new Song("track4", "Get Jinxed", "Metal", 2014, artists.subList(3, 4), albums.get(3)));
        songs.add(new Song("track5", "Care for another?", "Jazz", 2017, artists.subList(4, 5), albums.get(4)));
    }
}
