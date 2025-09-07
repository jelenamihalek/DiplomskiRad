package diplomski_rad.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="publishers")
public class PublisherModel {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;

    @Column(nullable = false, unique = true)
    private String publisherName;

    @Column(nullable = false)
    private String publisherCity;

    
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
	@JsonIgnore
    private List<BookModel> books;

    public PublisherModel() {
        super();
    }

    public PublisherModel(Long publisherId, String publisherName, String publisherCity) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
        this.publisherCity = publisherCity;
    }

    public PublisherModel(String publisherName, String publisherCity) {
        this.publisherName = publisherName;
        this.publisherCity = publisherCity;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherCity() {
        return publisherCity;
    }

    public void setPublisherCity(String publisherCity) {
        this.publisherCity = publisherCity;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
