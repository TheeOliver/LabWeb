package mk.ukim.finki.labapp.repository.jpa;
import mk.ukim.finki.labapp.model.Album;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {

}
