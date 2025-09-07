package diplomski_rad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import diplomski_rad.models.AuthorModel;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "authors",path = "author")
public interface AuthorRepository extends JpaRepository<AuthorModel,Long> {

}
