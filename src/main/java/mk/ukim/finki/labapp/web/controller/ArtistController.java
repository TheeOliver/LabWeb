package mk.ukim.finki.labapp.web.controller;

import mk.ukim.finki.labapp.model.Artist;
import mk.ukim.finki.labapp.model.Song;
import mk.ukim.finki.labapp.service.ArtistService;
import mk.ukim.finki.labapp.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/artist-form")
public class ArtistController {

    ArtistService artistService;
    SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @PostMapping
    public String getAddArtistPage(@RequestParam String trackId, Model model) {
        model.addAttribute("artists", artistService.listArtists().stream()
                .filter(x->!songService.findByTrackId(trackId).getArtists().contains(x)));
        model.addAttribute("songId", trackId);
        return "artistsList";
    }

    @PostMapping("/add/{id}")
    public String addArtist(@PathVariable String id,
                            @RequestParam Long artistId) {

        Song song = songService.findByTrackId(id);
        Artist artist = artistService.findById(artistId).orElse(null);
        artistService.addSongToArtist(artist, song);
        return "redirect:/song-details/" + song.getId();
    }

}
