package diplomski_rad.models;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "books")
public class BookModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(nullable = false, unique = true, length = 20)
    private String isbn;

    @Column(nullable = false)
    private Date dateOfPublish;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column
    private String picturePath;

    @Column
    private Double discount; // npr. 0.15 = 15%

   
    @Column(nullable = false)
    private Integer quantity;

    
    // --- Relacije ---

    public BookModel(Long bookId, String isbn, Date dateOfPublish, String title, String description, BigDecimal price,
			String picturePath, Double discount, Integer quantity, AuthorModel author, PublisherModel publisher,
			Set<GenreModel> genres, List<ReviewModel> reviews) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.dateOfPublish = dateOfPublish;
		this.title = title;
		this.description = description;
		this.price = price;
		this.picturePath = picturePath;
		this.discount = discount;
		this.quantity = quantity;
		this.author = author;
		this.publisher = publisher;
		this.genres = genres;
		this.reviews = reviews;
	}

	public BookModel(String isbn, Date dateOfPublish, String title, String description, BigDecimal price,
			String picturePath, Double discount, Integer quantity, AuthorModel author, PublisherModel publisher,
			Set<GenreModel> genres, List<ReviewModel> reviews) {
		super();
		this.isbn = isbn;
		this.dateOfPublish = dateOfPublish;
		this.title = title;
		this.description = description;
		this.price = price;
		this.picturePath = picturePath;
		this.discount = discount;
		this.quantity = quantity;
		this.author = author;
		this.publisher = publisher;
		this.genres = genres;
		this.reviews = reviews;
	}

	

	// Knjiga ima jednog autora
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private AuthorModel author;

    // Knjiga ima jednog izdavača
    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private PublisherModel publisher;

    // Knjiga može imati više žanrova
    @ManyToMany
    @JoinTable(
        name = "book_genres",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<GenreModel> genres;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReviewModel> reviews;

    public List<ReviewModel> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewModel> reviews) {
		this.reviews = reviews;
	}

	// --- Konstruktori ---
    public BookModel() {}

    // --- Getteri i setteri ---
    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDateOfPublish() {
        return dateOfPublish;
    }

    public void setDateOfPublish(Date dateOfPublish) {
        this.dateOfPublish = dateOfPublish;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public AuthorModel getAuthor() {
        return author;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }

    public PublisherModel getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherModel publisher) {
        this.publisher = publisher;
    }

    public Set<GenreModel> getGenres() {
        return genres;
    }

    public void setGenres(Set<GenreModel> genres) {
        this.genres = genres;
    }

    public BigDecimal getPriceWithDiscount() {
        if (discount == null || discount <= 0) {
            return price;
        }
        return price.subtract(price.multiply(BigDecimal.valueOf(discount)));
    }
    
}
