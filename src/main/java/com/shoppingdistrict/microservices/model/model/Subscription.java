package com.shoppingdistrict.microservices.model.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;


@Entity
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "firstname")
	@Size(min = 2, message = "First Name should have at least two characters")
	private String firstname;

	

	@Column(name = "email")
	@Email(message = "Please enter valid email")
	private String email;

	@Column(name = "email_verified")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean emailVerified;

	public Subscription() {

	}

	public Subscription(int id, @Size(min = 2, message = "First Name should have at least two characters") String firstname,
			 @Email(message = "Please enter valid email") String email, boolean emailVerified) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.email = email;
		this.emailVerified = emailVerified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	

	@Override
	public String toString() {
		return "User [id=" + id + ", First name=" + firstname + ", email=" + email + "]";
	}

}
