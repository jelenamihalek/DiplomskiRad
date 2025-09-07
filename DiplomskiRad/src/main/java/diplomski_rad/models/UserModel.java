package diplomski_rad.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userFirstName;

    @Column(nullable = false)
    private String userLastName;

    @Column(nullable = false, unique = true)
    private String userUsername;

    @Column(nullable = false, unique = true)
    private String userEmail;

    @Column(nullable = true)
    private String userPhone;

    @Column(nullable = true)
    private String userPostalCode;

    @Column(nullable = true)
    private String userCity;

    @Column(nullable = true)
    private String userStreet;

    @Column(nullable = true)
    private LocalDate userDateOfBirth;

    @Column(nullable = false)
    private String userPassword;

  
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<OrderModel> orders;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private WishlistModel wishlist;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ReviewModel> reviews;

   
    public UserModel() {
        super();
    }

    public UserModel(Long userId, String userFirstName, String userLastName, String userUsername,
                     String userEmail, String userPhone, String userPostalCode, String userCity,
                     String userStreet, LocalDate userDateOfBirth, String userPassword) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userUsername = userUsername;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userPostalCode = userPostalCode;
        this.userCity = userCity;
        this.userStreet = userStreet;
        this.userDateOfBirth = userDateOfBirth;
        this.userPassword = userPassword;
    }

    
    public UserModel(String userFirstName, String userLastName, String userUsername, String userEmail, String userPhone,
			String userPostalCode, String userCity, String userStreet, LocalDate userDateOfBirth, String userPassword,
			List<OrderModel> orders, WishlistModel wishlist, List<ReviewModel> reviews) {
		super();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userUsername = userUsername;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userPostalCode = userPostalCode;
		this.userCity = userCity;
		this.userStreet = userStreet;
		this.userDateOfBirth = userDateOfBirth;
		this.userPassword = userPassword;
		this.orders = orders;
		this.wishlist = wishlist;
		this.reviews = reviews;
	}

	public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getUserFirstName() { return userFirstName; }
    public void setUserFirstName(String userFirstName) { this.userFirstName = userFirstName; }

    public String getUserLastName() { return userLastName; }
    public void setUserLastName(String userLastName) { this.userLastName = userLastName; }

    public String getUserUsername() { return userUsername; }
    public void setUserUsername(String userUsername) { this.userUsername = userUsername; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getUserPhone() { return userPhone; }
    public void setUserPhone(String userPhone) { this.userPhone = userPhone; }

    public String getUserPostalCode() { return userPostalCode; }
    public void setUserPostalCode(String userPostalCode) { this.userPostalCode = userPostalCode; }

    public String getUserCity() { return userCity; }
    public void setUserCity(String userCity) { this.userCity = userCity; }

    public String getUserStreet() { return userStreet; }
    public void setUserStreet(String userStreet) { this.userStreet = userStreet; }

    public LocalDate getUserDateOfBirth() { return userDateOfBirth; }
    public void setUserDateOfBirth(LocalDate userDateOfBirth) { this.userDateOfBirth = userDateOfBirth; }

    public String getUserPassword() { return userPassword; }
    public void setUserPassword(String userPassword) { this.userPassword = userPassword; }

    public List<OrderModel> getOrders() { return orders; }
    public void setOrders(List<OrderModel> orders) { this.orders = orders; }

    public WishlistModel getWishlist() { return wishlist; }
    public void setWishlist(WishlistModel wishlist) { this.wishlist = wishlist; }

    public List<ReviewModel> getReviews() { return reviews; }
    public void setReviews(List<ReviewModel> reviews) { this.reviews = reviews; }
}
