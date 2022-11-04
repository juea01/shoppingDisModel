package com.shoppingdistrict.microservices.model.model;

import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;

	@Column(name = "cart_price")
	@DecimalMin(value = "0.0", inclusive = false)
	@Digits(integer = 11, fraction = 2)
	private BigDecimal cartPrice;

	@Column(name = "item_count")
	private int itemCount;

	@OneToOne(fetch = FetchType.LAZY, mappedBy="cart") // this way "mappedBy" only create relationship column in Order, not in user
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Orders order;
	
	
	@OneToMany(mappedBy = "cart") // this way "mappedBy" only create relationship column in Line, not in here
	//@Cascade({CascadeType.ALL})
	private List<Line> lines;

	// customer and cart:{
//    lines: [
//            {product:{type: Schema.Types.ObjectId, ref: 'Product'},quantity:{type: Number}}
//           ],
//         itemCount: {type: Number, required: true},
//         price: {type: Number, required: true}
//     }

//order date
//shipment date
//status (can be enum type shipping, cancel, successful, dispute, order-received)

	public Cart() {

	}

	
	
	

	public Cart(int id,
			@DecimalMin(value = "0.0", inclusive = false) @Digits(integer = 11, fraction = 2) BigDecimal cartPrice,
			int itemCount, Orders order, List<Line> lines) {
		super();
		this.id = id;
		this.cartPrice = cartPrice;
		this.itemCount = itemCount;
		this.order = order;
		this.lines = lines;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


	public BigDecimal getCartPrice() {
		return cartPrice;
	}

	public void setCartPrice(BigDecimal cartPrice) {
		this.cartPrice = cartPrice;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}
	
	

}
