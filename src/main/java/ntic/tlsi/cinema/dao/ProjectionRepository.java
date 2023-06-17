package ntic.tlsi.cinema.dao;

import ntic.tlsi.cinema.entities.Place;
import ntic.tlsi.cinema.entities.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("https://cinema-frontend-angualr.netlify.app")
public interface ProjectionRepository extends JpaRepository<Projection,Long> {
}
