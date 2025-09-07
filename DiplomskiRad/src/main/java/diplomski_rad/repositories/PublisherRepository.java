package diplomski_rad.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import diplomski_rad.models.PublisherModel;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "publishers",path = "publisher")
public interface PublisherRepository extends JpaRepository<PublisherModel,Long> {

}
