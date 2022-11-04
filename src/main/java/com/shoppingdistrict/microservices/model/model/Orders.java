package com.shoppingdistrict.microservices.model.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "Shipped", columnDefinition = "org.hibernate.type.NumericBooleanType false")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean shipped;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling Customer and order indefinitely
	@JoinColumn(name = "user_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Users user;
	
	@OneToOne()
	@JoinColumn(name = "cart_id")
	//@Cascade({CascadeType.ALL})
	private Cart cart;
	
	@Column(name = "firstname")
	//@Size(min = 2, message = "First Name should have at least two characters")
	private String firstname;
	
	@Column(name = "lastname")
	//@Size(min = 2, message = "Last Name should have at least two characters")
	private String lastname;

	@Column(name = "email")
	//@Email(message = "Please enter valid email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "address")
	//@Size(min = 5, message = "Address should have atleast 5 characters")
	private String address;

	@Column(name = "city")
	//@Size(min = 2, message = "City name should have atleast 2 characters")
	private String city;

	@Column(name = "state")
	//@Size(min = 2, message = "State name should have atleast 2 characters")
	private String state;

	@Column(name = "country")
	//@Size(min = 2, message = "Country name should have atleast 2 characters")
	private String country;

	@Column(name = "postal_code")
	//@Digits(integer = 4, fraction = 0, message = "Please enter valid Postal code")
	private int postalCode;

	@Column(name = "email_promotion")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean emailPromotion;

	// customer and cart:{
//    lines: [
//            {product:{type: Schema.Types.ObjectId, ref: 'Product'},quantity:{type: Number}}
//           ],
//         itemCount: {type: Number, required: true},
//         price: {type: Number, required: true}
//     }

//order date
//shipment date
//status (can be enum type shipping, cancel, successful, dispute, order-received)

	public Orders() {

	}

	public Orders(int id, boolean shipped, Users user) {
		super();
		this.id = id;
		this.shipped = shipped;
		this.user = user;
	}
	
	

	public Orders(int id, boolean shipped, Users user, Cart cart) {
		super();
		this.id = id;
		this.shipped = shipped;
		this.user = user;
		this.cart = cart;
	}
	
	

	public Orders(int id, boolean shipped, Users user, Cart cart,
			@Size(min = 2, message = "First Name should have at least two characters") String firstname,
			@Size(min = 2, message = "Last Name should have at least two characters") String lastname,
			@Email(message = "Please enter valid email") String email, String phone,
			@Size(min = 5, message = "Address should have atleast 5 characters") String address,
			@Size(min = 2, message = "City name should have atleast 2 characters") String city,
			@Size(min = 2, message = "State name should have atleast 2 characters") String state,
			@Size(min = 2, message = "Country name should have atleast 2 characters") String country,
			@Digits(integer = 4, fraction = 0, message = "Please enter valid Postal code") int postalCode,
			boolean emailPromotion) {
		super();
		this.id = id;
		this.shipped = shipped;
		this.user = user;
		this.cart = cart;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.emailPromotion = emailPromotion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isShipped() {
		return shipped;
	}

	public void setShipped(boolean shipped) {
		this.shipped = shipped;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isEmailPromotion() {
		return emailPromotion;
	}

	public void setEmailPromotion(boolean emailPromotion) {
		this.emailPromotion = emailPromotion;
	}

	// User should not be here in toString() method to avoid loops
	@Override
	public String toString() {
		return "Order [id=" + id + ", shipped=" + shipped + "]";
	}

}
