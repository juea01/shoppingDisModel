package com.shoppingdistrict.microservices.model.model;

import java.sql.Timestamp;
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
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "email")
	@Email(message = "Please enter valid email")
	private String email;

	@Column(name = "prefer_lecturer_type")
	@Size(max = 40, message = "Prefer Lecturer Type should not exceed more that 40 characters")
	private String preferLect;

	@Column(name = "time_constrained_test")
	@Size(max = 40, message = "Time-constrained test Type should not exceed more that 40 characters")
	private String timeConTest;

	@Column(name = "prefer_subscription_amount")
	@Size(max = 40, message = "Subscription amount Type should not exceed more that 40 characters")
	private String preferSubAmo;

	@Column(name = "comment")
	@Size(max = 450, message = "Comment should not exceed more that 450 characters")
	private String comment;

	@Column(name = "accept_for_contact")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean acceptForCont;

	public Feedback() {

	}

	public Feedback(int id, String email, String preferLect, String timeConTest, String preferSubAmo, String comment,
			boolean acceptForCont) {
		super();
		this.id = id;
		this.email = email;
		this.preferLect = preferLect;
		this.timeConTest = timeConTest;
		this.preferSubAmo = preferSubAmo;
		this.comment = comment;
		this.acceptForCont = acceptForCont;
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

	public String getPreferLect() {
		return preferLect;
	}

	public void setPreferLect(String preferLect) {
		this.preferLect = preferLect;
	}

	public String getTimeConTest() {
		return timeConTest;
	}

	public void setTimeConTest(String timeConTest) {
		this.timeConTest = timeConTest;
	}

	public String getPreferSubAmo() {
		return preferSubAmo;
	}

	public void setPreferSubAmo(String preferSubAmo) {
		this.preferSubAmo = preferSubAmo;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isAcceptForCont() {
		return acceptForCont;
	}

	public void setAcceptForCont(boolean acceptForCont) {
		this.acceptForCont = acceptForCont;
	}

}
