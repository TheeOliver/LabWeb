package mk.ukim.finki.labapp.repository.jpa;

import mk.ukim.finki.labapp.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

}
