package com.shoppingdistrict.microservices.model.model;

import java.math.BigDecimal;
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

	@Column(name = "price")
	@DecimalMin(value="0.0", inclusive=false)
	@Digits(integer=11, fraction=2)
	private BigDecimal price;
	
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
			@DecimalMin(value = "0.0", inclusive = false) @Digits(integer = 11, fraction = 2) BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
	}
	
	

	public Products(int id, @Size(min = 2, message = "Name should have at least two characters") String name,
			@Size(min = 2, message = "Category should have at least two characters") String category,
			@Size(min = 5, message = "Description should have at least five characters") String description,
			@DecimalMin(value = "0.0", inclusive = false) @Digits(integer = 11, fraction = 2) BigDecimal price,
			List<Line> lines) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.description = description;
		this.price = price;
		this.lines = lines;
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", price=" + price + "]";
	}
	
	
	
	

}
