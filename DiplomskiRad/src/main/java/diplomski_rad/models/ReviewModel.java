package diplomski_rad.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reviews")
public class ReviewModel {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long reviewId;

 private int rating; // npr. 1-5
 private String comment;
 private LocalDate date;

 // Veza sa korisnikom (jedan korisnik -> više recenzija)
 @ManyToOne
 @JoinColumn(name = "user_id", nullable = false)
 private UserModel user;

 // Veza sa knjigom (jedna knjiga -> više recenzija)
 @ManyToOne
 @JoinColumn(name = "book_id", nullable = false)
 private BookModel book;

 // Getteri i setteri
 public Long getReviewId() {
     return reviewId;
 }

 public void setReviewId(Long reviewId) {
     this.reviewId = reviewId;
 }

 public int getRating() {
     return rating;
 }

 public void setRating(int rating) {
     this.rating = rating;
 }

 public String getComment() {
     return comment;
 }

 public void setComment(String comment) {
     this.comment = comment;
 }

 public LocalDate getDate() {
     return date;
 }

 public void setDate(LocalDate date) {
     this.date = date;
 }

 public UserModel getUser() {
     return user;
 }

 public void setUser(UserModel user) {
     this.user = user;
 }

 public BookModel getBook() {
     return book;
 }

 public void setBook(BookModel book) {
     this.book = book;
 }
}
