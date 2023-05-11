package com.shoppingdistrict.microservices.model.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "firstname")
	@Size(min = 2, message = "First Name should have at least two characters")
	private String firstname;

	@Column(name = "lastname")
	@Size(min = 2, message = "Last Name should have at least two characters")
	private String lastname;

	@Column(name = "username")
	@Size(min = 2, message = "Name should have at least two characters")
	private String username;

	@Column(name = "password")
	@Size(min = 7, message = "Password should have at least seven characters")
	private String password;

	@Column(name = "enabled")
	private int enabled;

	@Column(name = "role")
	private String role;

	@Column(name = "email")
	@Email(message = "Please enter valid email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@Column(name = "address")
	private String address;

	@Column(name = "city")
	@Size(min = 2, message = "City name should have atleast 2 characters")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	@Size(min = 2, message = "Country name should have atleast 2 characters")
	private String country;

	@Column(name = "postal_code")
	private int postalCode;

	@Column(name = "email_promotion")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean emailPromotion;

	@Column(name = "email_verified")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean emailVerified;

	@Column(name = "occupation")
	@Size(min = 2, message = "Occupation should have at least two characters")
	private String occupation;

	@Column(name = "gender")
	@Size(min = 2, message = "Gender should have at least two characters")
	private String gender;

	@OneToMany(mappedBy = "user") // this way "mappedBy" only create relationship column in Order, not in user
	@JsonIgnore
	private List<Orders> orders;

	@OneToMany(mappedBy = "user") // this way "mappedBy" only create relationship column in article, not in user
	@JsonIgnore
	private List<Articles> articles;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Comment> comments;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Reply> replies;

	public Users() {

	}

	public Users(int id, @Size(min = 2, message = "First Name should have at least two characters") String firstname,
			@Size(min = 2, message = "Last Name should have at least two characters") String lastname,
			@Size(min = 2, message = "User Name should have at least two characters") String username,
			@Size(min = 7, message = "Password should have at least seven characters") String password, int enabled,
			String role, @Email(message = "Please enter valid email") String email, String phone,
			String address,
			@Size(min = 2, message = "City name should have atleast 2 characters") String city,
			String state,
			@Size(min = 2, message = "Country name should have atleast 2 characters") String country,
			int postalCode,
			boolean emailPromotion, boolean emailVerified, List<Orders> orders, List<Articles> articles,
			List<Comment> comments, List<Reply> reply, @Size(min = 2, message = "Occupation should have at least two characters") String occupation, 
			@Size(min = 2, message = "Gender should have at least two characters") String gender) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.postalCode = postalCode;
		this.emailPromotion = emailPromotion;
		this.emailVerified = emailVerified;
		this.orders = orders;
		this.articles = articles;
		this.comments = comments;
		this.replies = reply;
		this.occupation = occupation;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<Articles> getArticles() {
		return articles;
	}

	public void setArticles(List<Articles> articles) {
		this.articles = articles;
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

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Reply> getReply() {
		return replies;
	}

	public void setReply(List<Reply> reply) {
		this.replies = reply;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + ", email=" + email + "]";
	}

}
