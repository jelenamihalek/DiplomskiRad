package diplomski_rad.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "authors")
public class AuthorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;

    @Column(nullable = false)
    private String authorName;

    @Column(nullable = false)
    private String lastName;
    
    @Column(length = 2000)
    private String biography;
    
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<BookModel> books;
    
    
	public AuthorModel() {
		super();
	}

	public AuthorModel(String authorName, String lastName, String biography, LocalDate dateOfBirth,
			List<BookModel> books) {
		super();
		this.authorName = authorName;
		this.lastName = lastName;
		this.biography = biography;
		this.dateOfBirth = dateOfBirth;
		this.books = books;
	}

	public AuthorModel(Long authorId, String authorName, String lastName, String biography, LocalDate dateOfBirth,
			List<BookModel> books) {
		super();
		this.authorId = authorId;
		this.authorName = authorName;
		this.lastName = lastName;
		this.biography = biography;
		this.dateOfBirth = dateOfBirth;
		this.books = books;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<BookModel> getBooks() {
		return books;
	}

	public void setBooks(List<BookModel> books) {
		this.books = books;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return this.authorId;
	}

    
    

}
