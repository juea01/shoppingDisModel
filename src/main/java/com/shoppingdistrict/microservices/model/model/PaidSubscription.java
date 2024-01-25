package com.shoppingdistrict.microservices.model.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class PaidSubscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling Users and PaidSubscription indefinitely
	@JoinColumn(name = "user_id")
	private Users user;
	
	@Column(name="ext_id")
	private String thirdPartyUserId;  //for example stripe customer id
	
	@Column(name="subscription_type")
	private String subscriptionType;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name = "active_subscription")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean activeSubscription;
	
	@Column(name = "paymentdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp lastPaidDate;

	public PaidSubscription() {
		
	}
	
	public PaidSubscription(int id, Users user, String thirdPartyUserId, String subscriptionType, String comment,
			boolean activeSubscription, Timestamp lastPaidDate) {
		super();
		this.id = id;
		this.user = user;
		this.thirdPartyUserId = thirdPartyUserId;
		this.subscriptionType = subscriptionType;
		this.comment = comment;
		this.activeSubscription = activeSubscription;
		this.lastPaidDate = lastPaidDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getThirdPartyUserId() {
		return thirdPartyUserId;
	}

	public void setThirdPartyUserId(String thirdPartyUserId) {
		this.thirdPartyUserId = thirdPartyUserId;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isActiveSubscription() {
		return activeSubscription;
	}

	public void setActiveSubscription(boolean activeSubscription) {
		this.activeSubscription = activeSubscription;
	}

	public Timestamp getLastPaidDate() {
		return lastPaidDate;
	}

	public void setLastPaidDate(Timestamp lastPaidDate) {
		this.lastPaidDate = lastPaidDate;
	}
	
	
	
	
}
