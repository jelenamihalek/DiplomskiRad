package diplomski_rad.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class OrderModel {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long orderId;

 private String paymentMethod;
 private String status;
 private Double totalPrice;

 @ManyToOne
 @JoinColumn(name = "user_id")
 private UserModel user;


 public Long getOrderId() { return orderId; }
 public void setOrderId(Long orderId) { this.orderId = orderId; }

 public String getPaymentMethod() { return paymentMethod; }
 public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

 public String getStatus() { return status; }
 public void setStatus(String status) { this.status = status; }

 public Double getTotalPrice() { return totalPrice; }
 public void setTotalPrice(Double totalPrice) { this.totalPrice = totalPrice; }

 public UserModel getUser() { return user; }
 public void setUser(UserModel user) { this.user = user; }
}
