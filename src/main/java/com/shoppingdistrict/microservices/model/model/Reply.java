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
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Reply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "description")
	@Size(min = 10, max = 150, message = "Description should have at least 10 characters and no more than 130 characters")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling user and comment indefinitely
	@JoinColumn(name = "user_id")
	private Users user;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling article and comment
										// indefinitely
	@JoinColumn(name = "comment_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Comment comment;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling article and comment
										// indefinitely
	@JoinColumn(name = "article_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Articles article;

	public Reply() {

	}

	public Reply(int id,
			@Size(min = 10, max = 150, message = "Description should have at least 10 characters and no more than 130 characters") String description,
			Users user, Comment comment, Articles article) {
		super();
		this.id = id;
		this.description = description;
		this.user = user;
		this.comment = comment;
		this.article = article;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public Articles getArticle() {
		return article;
	}

	public void setArticle(Articles article) {
		this.article = article;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", description=" + description + "]";
	}

}
