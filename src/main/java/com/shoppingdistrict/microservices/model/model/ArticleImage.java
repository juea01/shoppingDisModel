package com.shoppingdistrict.microservices.model.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class ArticleImage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "location")
	private String location;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling image and article indefinitely
	@JoinColumn(name = "article_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Articles article;

	public ArticleImage() {

	}

	public ArticleImage(int id, String name, String location, Articles article) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.article = article;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setArticle(Articles article) {
		this.article = article;
	}

}
