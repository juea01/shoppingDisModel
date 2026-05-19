package com.shoppingdistrict.microservices.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Type;


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
	
	@Column(name = "subscription_id", length = 255)
    private String stripeSubscriptionId;
	
	@Column(name="subscription_type")
	private String subscriptionType;
	
	@Column(name="comment")
	private String comment;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private SubscriptionStatus status;
	
	@Column(name = "active_subscription")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean activeSubscription;
	
	@Column(name = "amount", precision = 10, scale = 2, nullable = false)
	private BigDecimal amount;
	
	@Column(name = "paymentdate", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	private Timestamp lastPaidDate;
	
	@Column(name = "expire_date")
	private Timestamp expiryDate;	

	public PaidSubscription() {
		
	}
	
	public PaidSubscription(int id, Users user, String thirdPartyUserId, String stripeSubscriptionId, String subscriptionType, BigDecimal amount, String comment,
			SubscriptionStatus status, boolean activeSubscription, Timestamp lastPaidDate, Timestamp expiryDate) {
		super();
		this.id = id;
		this.user = user;
		this.thirdPartyUserId = thirdPartyUserId;
		this.stripeSubscriptionId = stripeSubscriptionId;
		this.subscriptionType = subscriptionType;
		this.amount = amount;
		this.comment = comment;
		this.status = status;
		this.activeSubscription = activeSubscription;
		this.lastPaidDate = lastPaidDate;
		this.expiryDate = expiryDate;
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
	
	public String getStripeSubscriptionId() {
		return stripeSubscriptionId;
	}

	public void setStripeSubscriptionId(String stripeSubscriptionId) {
		this.stripeSubscriptionId = stripeSubscriptionId;
	}

	public String getSubscriptionType() {
		return subscriptionType;
	}

	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}
	
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
	
	public SubscriptionStatus getStatus() {
		return status;
	}

	public void setStatus(SubscriptionStatus status) {
		this.status = status;
	}

	public Timestamp getLastPaidDate() {
		return lastPaidDate;
	}

	public void setLastPaidDate(Timestamp lastPaidDate) {
		this.lastPaidDate = lastPaidDate;
	}

	public Timestamp getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}
	
}
