package com.shoppingdistrict.microservices.model.model;

import java.sql.Date;
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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Articles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	@Size(min = 2, max = 35, message = "Title should have at least two characters and no more than 35 characters")
	private String title;

	@Column(name = "category")
	@Size(min = 2, max = 35, message = "Category should have at least two characters and no more than 35 characters")
	private String category;

	@Column(name = "sub_category")
	@Size(min = 2, max = 35, message = "Sub Category should have at least two characters and no more than 35 characters")
	private String subcategory;

	@Column(name = "description")
	@Size(min = 10, max = 75, message = "Description should have at least 10 characters and no more than 75 characters")
	private String description;

	@Column(name = "content")
	@Size(min = 20, message = "Content should have at least 20 characters and no more than 550 characters")
	private String content;

	@Column(name = "publishdate")
	private Date publishDate;

	@Column(name = "lasteditdate")
	private Date lastEditDate;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling user and article indefinitely
	@JoinColumn(name = "user_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Users user;

	@OneToMany(mappedBy = "article") // this way "mappedBy" only create relationship column in comment, not in articles
	private List<Comment> comments;

	public Articles() {

	}

	public Articles(int id,
			@Size(min = 2, max = 35, message = "Title should have at least two characters and no more than 35 characters") String title,
			@Size(min = 2, max = 35, message = "Category should have at least two characters and no more than 35 characters") String category,
			@Size(min = 2, max = 35, message = "Sub Category should have at least two characters and no more than 35 characters") String subcategory,
			@Size(min = 10, max = 75, message = "Description should have at least 10 characters and no more than 75 characters") String description,
			@Size(min = 20, message = "Content should have at least 20 characters and no more than 550 characters") String content,
			Date publishDate, Date lastEditDate, Users user, List<Comment> comments) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.subcategory = subcategory;
		this.description = description;
		this.content = content;
		this.publishDate = publishDate;
		this.lastEditDate = lastEditDate;
		this.user = user;
		this.comments = comments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public Date getLastEditDate() {
		return lastEditDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", category=" + category + "]";
	}

}
