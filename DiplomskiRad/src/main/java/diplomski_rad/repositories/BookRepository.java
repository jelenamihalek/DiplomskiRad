package diplomski_rad.repositories;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import diplomski_rad.models.AuthorModel;
import diplomski_rad.models.BookModel;
import java.util.List;
import java.util.Set;
import diplomski_rad.models.GenreModel;


@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "books",path = "book")
public interface BookRepository extends JpaRepository<BookModel, Long> {

	

	    // postojeća metoda – očekuje ceo objekat autora (URI)
	    Page<BookModel> findByAuthor(@Param("author") AuthorModel author, Pageable pageable);

	    // nova pomoćna metoda – očekuje samo ID autora
	    Page<BookModel> findByAuthorId(@RequestParam(required = false) Long authorId, Pageable pageable);
	


}
