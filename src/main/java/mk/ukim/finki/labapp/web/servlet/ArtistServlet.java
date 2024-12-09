package mk.ukim.finki.labapp.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.ukim.finki.labapp.model.Artist;
import mk.ukim.finki.labapp.service.ArtistService;
import mk.ukim.finki.labapp.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(name="ArtistServlet", urlPatterns = "/artist")
public class ArtistServlet extends HttpServlet {
    private final SongService songService;
    private final ArtistService artistService;
    private final SpringTemplateEngine springTemplateEngine;

    public ArtistServlet(SongService songService, ArtistService artistService, SpringTemplateEngine springTemplateEngine) {
        this.songService = songService;
        this.artistService = artistService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        String songId = req.getParameter("songId");
        context.setVariable("artists", artistService.listArtists().stream().filter(x->
                !songService.findByTrackId(songId).getArtists().contains(x)).collect(Collectors.toList()));
        context.setVariable("songId", songId);
        springTemplateEngine.process("artistsList.html",context,resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long artistId = Long.parseLong(req.getParameter("artistId"));
        String songId = req.getParameter("songId");

        Optional<Artist> artist = artistService.findById(artistId);
        if(artist.isPresent()) {
            songService.addArtistToSong(artist.orElse(null), songService.findByTrackId(songId)); // prashaj za ova
        }

        if (songId != null && !songId.isEmpty()) {
            resp.sendRedirect("/songDetails?songId=" + songId);
        } else {
            resp.sendRedirect("/artist?songId=" + songId);
        }
    }
}
