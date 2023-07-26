package com.shoppingdistrict.microservices.model.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "category")
	@Size(min = 3, max = 30, message = "Category should have at least 3 characters and no more than 30 characters")
	private String category;

	@Column(name = "sub_category")
	@Size(min = 3, max = 30, message = "Sub Category should have at least 3 characters and no more than 30 characters")
	private String subCategory;

	@Column(name = "level")
	private int level;

	@Column(name = "title")
	@Size(min = 3, max = 30, message = "Title should have at least 3 characters and no more than 30 characters")
	private String title;

	@Column(name = "premium")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isPremium;

	@OneToMany(mappedBy = "subject") // this way "mappedBy" only create relationship column in Question, not
										// here
	@JsonIgnore
	private List<Question> questions;

	@OneToMany(mappedBy = "subject") // this way "mappedBy" only create relationship column in UserSubject, not
	// here
	@JsonIgnore
	private List<UserSubject> userSubjects;

	public Subject() {

	}

	public Subject(int id,
			@Size(min = 3, max = 30, message = "Category should have at least 3 characters and no more than 30 characters") String category,
			@Size(min = 3, max = 30, message = "Sub Category should have at least 3 characters and no more than 30 characters") String subCategory,
			int level,
			@Size(min = 3, max = 30, message = "Title should have at least 3 characters and no more than 30 characters") String title,
			boolean isPremium, List<Question> questions, List<UserSubject> userSubjects) {
		super();
		this.id = id;
		this.category = category;
		this.subCategory = subCategory;
		this.level = level;
		this.title = title;
		this.isPremium = isPremium;
		this.questions = questions;
		this.userSubjects = userSubjects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public boolean isPremium() {
		return isPremium;
	}

	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}

	public List<UserSubject> getUserSubjects() {
		return userSubjects;
	}

	public void setUserSubjects(List<UserSubject> userSubjects) {
		this.userSubjects = userSubjects;
	}

}
