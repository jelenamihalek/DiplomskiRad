package diplomski_rad.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "wishlists")
public class WishlistModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishlistId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private UserModel user;

    @ManyToMany
    @JoinTable(
        name = "wishlist_books",
        joinColumns = @JoinColumn(name = "wishlist_id"),
        inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    
 //   @Column(nullable = false)
   // private LocalDateTime createdAt; 
    
    private List<BookModel> books;

    public WishlistModel() {
        super();
      //  this.createdAt = LocalDateTime.now();
    }

    public WishlistModel(UserModel user, List<BookModel> books) {
        this.user = user;
        this.books = books;
        //this.createdAt = LocalDateTime.now();
    }

    public Long getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Long wishlistId) {
        this.wishlistId = wishlistId;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }
}
