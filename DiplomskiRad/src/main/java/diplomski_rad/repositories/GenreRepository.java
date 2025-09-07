package diplomski_rad.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import diplomski_rad.models.GenreModel;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "genres",path = "genre")
public interface GenreRepository extends JpaRepository<GenreModel, Long> {

	
	List<GenreModel> findByGenreNameContainingIgnoreCase(String name);
}
