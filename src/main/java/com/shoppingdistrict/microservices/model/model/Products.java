package com.shoppingdistrict.microservices.model.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	@Size(min = 2, message = "Name should have at least two characters")
	private String name;

	@Column(name = "category")
	@Size(min = 2, message = "Category should have at least two characters")
	private String category;

	@Column(name = "description")
	@Size(min = 5, message = "Description should have at least five characters")
	private String description;

	@Column(name = "suitable_audience")
	@Size(min = 3, message = "Suitable Auidence should have at least three characters")
	private String suitableAudience;

	@Column(name = "features")
	@Size(min = 5, message = "Features should have at least five characters")
	private String features;

	@Column(name = "seller_link")
	@Size(min = 5, message = "Seller Link should have at least five characters")
	private String sellerLink;

	@Column(name = "creationdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Timestamp publishDate;

	@Column(name = "lasteditdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp lastEditDate;

	@OneToMany(mappedBy = "product") // this way "mappedBy" only create relationship column in Line, not in here
	@JsonIgnore
	private List<Line> lines;

	@OneToMany(mappedBy = "product")
	private List<Image> images;

	public Products() {

	}

	public Products(int id, @Size(min = 2, message = "Name should have at least two characters") String name,
			@Size(min = 2, message = "Category should have at least two characters") String category,
			@Size(min = 5, message = "Description should have at least five characters") String description,
			List<Line> lines,
			@Size(min = 3, message = "Suitable Auidence should have at least three characters") String suitableAudience,
			@Size(min = 5, message = "Features should have at least five characters") String features,
			@Size(min = 5, message = "Seller Link should have at least five characters") String sellerLink,
			Timestamp publishDate, Timestamp lastEditDate) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.lines = lines;
		this.suitableAudience = suitableAudience;
		this.features = features;
		this.sellerLink = sellerLink;
		this.publishDate = publishDate;
		this.lastEditDate = lastEditDate;

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getSuitableAudience() {
		return suitableAudience;
	}

	public void setSuitableAudience(String suitableAudience) {
		this.suitableAudience = suitableAudience;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getSellerLink() {
		return sellerLink;
	}

	public void setSellerLink(String sellerLink) {
		this.sellerLink = sellerLink;
	}

	public Timestamp getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}

	public Timestamp getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(Timestamp lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", description=" + description + "]";
	}

}
