package diplomski_rad.models;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "genres")
public class GenreModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;

    @Column(nullable = false, unique = true)
    private String genreName;

    
    @ManyToMany(mappedBy = "genres")  // ← OVO je bitno
	@JsonIgnore
    private List<BookModel> books;


    public GenreModel() {
        super();
    }

    public GenreModel(Long genreId, String genreName) {
        super();
        this.genreId = genreId;
        this.genreName = genreName;
    }

    public GenreModel(String genreName) {
        this.genreName = genreName;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
