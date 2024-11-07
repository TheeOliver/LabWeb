package mk.ukim.finki.labapp.bootstrap;

import jakarta.annotation.PostConstruct;
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

    @PostConstruct
    public void init(){
        artists = new ArrayList<>();
        artists.add(new Artist(37L, "Kiril", "Stefanovski", "Pop diva"));
        artists.add(new Artist(44L, "Luka", "Mihajlovski", "Raper"));
        artists.add(new Artist(40L, "Jana", "Angeloska", "Indie guitarist"));
        artists.add(new Artist(13L, "Rebeka", "Maneva", "Rock band vocalist"));
        artists.add(new Artist(16L, "Dimitri", "Petrovski", "Jazzzyy"));

        songs = new ArrayList<>();
        songs.add(new Song("track1", "39.2", "Hyperpop", 2024, artists.stream().filter(a -> a.getFirstName().equals("Kiril")).collect(Collectors.toList())));
        songs.add(new Song("track2", "30 Denari", "Rap", 2019, artists.stream().filter(a -> a.getFirstName().equals("Luka")).collect(Collectors.toList())));
        songs.add(new Song("track3", "Od Jana verzijata", "Pop", 2014, artists.stream().filter(a -> a.getFirstName().equals("Jana")).collect(Collectors.toList())));
        songs.add(new Song("track4", "82nd all the way", "Metal", 2014, artists.stream().filter(a -> a.getFirstName().equals("Rebeka")).collect(Collectors.toList())));
        songs.add(new Song("track5", "Blues", "Jazz", 2017, artists.stream().filter(a -> a.getFirstName().equals("Dimitri")).collect(Collectors.toList())));
    }
}
