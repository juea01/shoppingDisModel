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
import javax.persistence.OneToOne;
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
	private String introduction;

	@Column(name = "first_paragraph")
	private String firstParagraph;

	@Column(name = "second_paragraph")
	private String secondParagraph;

	@Column(name = "conclusion")
	private String conclusion;

	@Column(name = "is_publish")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean isPublish;

	@Column(name = "publishdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp publishDate;

	@Column(name = "lasteditdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp lastEditDate;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling user and article indefinitely
	@JoinColumn(name = "user_id")
	private Users users;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "previous_article_id")
	private Articles previousArticle;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "next_article_id")
	private Articles nextArticle;

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
			String introduction, String firstParagraph, String secondParagraph, String conclusion, boolean isPublish,
			Timestamp publishDate, Timestamp lastEditDate, Users user, Articles previousArticle, Articles nextArticle,
			List<Comment> comments, List<Reply> replies, List<Question> questions) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.subcategory = subcategory;
		this.introduction = introduction;
		this.firstParagraph = firstParagraph;
		this.secondParagraph = secondParagraph;
		this.conclusion = conclusion;
		this.isPublish = isPublish;
		this.publishDate = publishDate;
		this.lastEditDate = lastEditDate;
		this.users = user;
		this.previousArticle = previousArticle;
		this.nextArticle = nextArticle;
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

	public boolean isPublish() {
		return isPublish;
	}

	public void setPublish(boolean isPublish) {
		this.isPublish = isPublish;
	}

	public Users getUser() {
		return users;
	}

	public void setUser(Users user) {
		this.users = user;
	}

	public Articles getPreviousArticle() {
		return previousArticle;
	}

	public void setPreviousArticle(Articles previousArticle) {
		this.previousArticle = previousArticle;
	}

	public Articles getNextArticle() {
		return nextArticle;
	}

	public void setNextArticle(Articles nextArticle) {
		this.nextArticle = nextArticle;
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
