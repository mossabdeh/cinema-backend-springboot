package ntic.tlsi.cinema.dao;

import ntic.tlsi.cinema.entities.Seance;
import ntic.tlsi.cinema.entities.Ville;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("https://cinema-frontend-angualr.netlify.app")
public interface VilleRepository extends JpaRepository<Ville,Long> {
}
