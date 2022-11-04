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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Line {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling cart and line indefinitely
	@JoinColumn(name = "cart_id")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Products product;

	@Column(name = "line_Price")
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 11, fraction = 2)
	private BigDecimal linePrice;

	@Column(name = "item_Count")
	private int itemCount;

	public Line() {

	}

	

	public Line(int id, Cart cart, Products product,
			@DecimalMin(value = "0.0", inclusive = false) @Digits(integer = 11, fraction = 2) BigDecimal linePrice,
			int itemCount) {
		super();
		this.id = id;
		this.cart = cart;
		this.product = product;
		this.linePrice = linePrice;
		this.itemCount = itemCount;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public BigDecimal getLinePrice() {
		return linePrice;
	}

	public void setLinePrice(BigDecimal linePrice) {
		this.linePrice = linePrice;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}



	public Products getProduct() {
		return product;
	}



	public void setProduct(Products product) {
		this.product = product;
	}
	
	

}
