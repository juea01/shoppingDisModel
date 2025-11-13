package com.shoppingdistrict.microservices.model.model;

import java.util.List;

import javax.persistence.CascadeType;
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
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "category")
	@Size(min = 3, max = 30, message = "Category should have at least 3 characters and no more than 30 characters")
	private String category;

	@Column(name = "sub_category")
	@Size(min = 2, max = 30, message = "Sub Category should have at least 2 characters and no more than 30 characters")
	private String subCategory;

	@Column(name = "level")
	private int level;

	@Column(name = "title")
	@Size(min = 3, max = 30, message = "Title should have at least 3 characters and no more than 30 characters")
	private String title;
	
	@Column(name = "description")
	@Size(min = 5, max = 250, message = "Description should have at least 5 characters and no more than 250 characters")
	private String description;

	@Column(name = "premium")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean premium;

	@Column(name = "is_publish")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isPublish;

	/**
	 * This way "mappedBy" only create relationship column in Articles, not here,
	 */
	@OneToMany(mappedBy = "course")
    @JsonIgnore 
	private List<Articles> articles;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling user and subject indefinitely
	@JoinColumn(name = "author_id")
	private Users user;

	public Course() {

	}

	public Course(int id,
			@Size(min = 3, max = 30, message = "Category should have at least 3 characters and no more than 30 characters") String category,
			@Size(min = 2, max = 30, message = "Sub Category should have at least 2 characters and no more than 30 characters") String subCategory,
			int level,
			@Size(min = 3, max = 30, message = "Title should have at least 3 characters and no more than 30 characters") String title,
			@Size(min = 5, max = 250, message = "Description should have at least 5 characters and no more than 250 characters") String description,
			boolean premium, boolean isPublish, List<Articles> articles, Users user) {
		super();
		this.id = id;
		this.category = category;
		this.subCategory = subCategory;
		this.level = level;
		this.title = title;
		this.description = description;
		this.premium = premium;
		this.isPublish = isPublish;
		this.articles = articles;
		this.user = user;
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


	public boolean isPremium() {
		return premium;
	}

	public void setPremium(boolean premium) {
		this.premium = premium;
	}

	public boolean isPublish() {
		return isPublish;
	}

	public void setPublish(boolean isPublish) {
		this.isPublish = isPublish;
	}


	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Articles> getArticles() {
		return articles;
	}

	public void setArticles(List<Articles> articles) {
		this.articles = articles;
	}
	
}
