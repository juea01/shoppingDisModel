package com.shoppingdistrict.microservices.model.model;

import java.sql.Date;
import java.sql.Timestamp;
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

	@Column(name = "introduction")
	@Size(min = 30, max = 245, message = "Introduction should have at least 30 characters and no more than 245 characters")
	private String introduction;

	@Column(name = "first_paragraph")
	@Size(min = 200, max = 395, message = "First paragraph should have at least 200 characters and no more than 395 characters")
	private String firstParagraph;

	@Column(name = "second_paragraph")
	@Size(min = 200, max = 395, message = "Second paragraph should have at least 200 characters and no more than 395 characters")
	private String secondParagraph;

	@Column(name = "conclusion")
	@Size(min = 200, max = 395, message = "Conclusion should have at least 200 characters and no more than 395 characters")
	private String conclusion;

	@Column(name = "publishdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp publishDate;

	@Column(name = "lasteditdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp lastEditDate;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling user and article indefinitely
	@JoinColumn(name = "user_id")
	private Users users;

	@OneToMany(mappedBy = "article") // this way "mappedBy" only create relationship column in comment, not in
										// articles
	private List<Comment> comments;

	@OneToMany(mappedBy = "article") // this way "mappedBy" only create relationship column in comment, not in
										// articles
	@JsonIgnore
	private List<Reply> replies;

	@OneToMany(mappedBy = "article")
	private List<ArticleImage> images;

	@OneToMany(mappedBy = "article") // this way "mappedBy" only create relationship column in question, not in
										// articles
	@JsonIgnore
	private List<Question> questions;

	public Articles() {

	}

	public Articles(int id,
			@Size(min = 2, max = 35, message = "Title should have at least two characters and no more than 35 characters") String title,
			@Size(min = 2, max = 35, message = "Category should have at least two characters and no more than 35 characters") String category,
			@Size(min = 2, max = 35, message = "Sub Category should have at least two characters and no more than 35 characters") String subcategory,
			@Size(min = 10, max = 245, message = "Introduction should have at least 30 characters and no more than 245 characters") String introduction,
			@Size(min = 200, max = 395, message = "First paragraph should have at least 200 characters and no more than 395 characters") String firstParagraph,
			@Size(min = 200, max = 395, message = "Second paragraph should have at least 200 characters and no more than 395 characters") String secondParagraph,
			@Size(min = 200, max = 395, message = "Conclusion should have at least 200 characters and no more than 395 characters") String conclusion,
			Timestamp publishDate, Timestamp lastEditDate, Users user, List<Comment> comments, List<Reply> replies,
			List<Question> questions) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.subcategory = subcategory;
		this.introduction = introduction;
		this.firstParagraph = firstParagraph;
		this.secondParagraph = secondParagraph;
		this.conclusion = conclusion;
		this.publishDate = publishDate;
		this.lastEditDate = lastEditDate;
		this.users = user;
		this.comments = comments;
		this.replies = replies;
		this.questions = questions;
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

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getFirstParagraph() {
		return firstParagraph;
	}

	public void setFirstParagraph(String firstParagraph) {
		this.firstParagraph = firstParagraph;
	}

	public String getSecondParagraph() {
		return secondParagraph;
	}

	public void setSecondParagraph(String secondParagraph) {
		this.secondParagraph = secondParagraph;
	}

	public String getConclusion() {
		return conclusion;
	}

	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}

	public Users getUser() {
		return users;
	}

	public void setUser(Users user) {
		this.users = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Timestamp getPublishDate() {
		return publishDate;
	}

	public Timestamp getLastEditDate() {
		return lastEditDate;
	}

	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}

	public void setLastEditDate(Timestamp lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public List<ArticleImage> getImages() {
		return images;
	}

	public void setImages(List<ArticleImage> images) {
		this.images = images;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", category=" + category + "]";
	}

}
