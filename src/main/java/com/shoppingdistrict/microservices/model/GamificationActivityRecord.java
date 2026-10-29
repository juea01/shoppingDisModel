package com.shoppingdistrict.microservices.model;

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
import javax.validation.constraints.Size;

import com.shoppingdistrict.microservices.model.dto.GamificationActivitySource;
import com.shoppingdistrict.microservices.model.dto.GamificationActivityType;
import com.shoppingdistrict.microservices.model.dto.GamificationXpCategory;

@Entity
public class GamificationActivityRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // note this approach doesn't allow batch processing
	@Column(name = "id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY) // Lazy should be here to avoid loops of calling user and subject indefinitely
	@JoinColumn(name = "user_id")
	private Users user;
	
	@Column(name = "idempotency_key", unique = true, nullable = false)
	private String idempotencyKey;
	
	@Column(name = "short_description")
	@Size(max = 155, message = "Short description should have no more than 155 characters")
	private String shortDescription;
	
	@Column(name = "awarded_xp", nullable = false)
    private int awardedXp;

    @Column(name = "occurred_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp occurredAt;

    @Column(name = "qualifies_for_streak", nullable = false)
    private boolean qualifiesForStreak;

    @Column(name = "qualifies_for_leaderboard", nullable = false)
    private boolean qualifiesForLeaderboard;

    @Enumerated(EnumType.STRING)
    @Column(name = "source_type", nullable = false)
    private GamificationActivitySource sourceType;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "activity_type", nullable = false)
    private GamificationActivityType activityType;

    @Enumerated(EnumType.STRING)
    @Column(name = "xp_category")
    private GamificationXpCategory xpCategory;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "university_id")
    private String universityId;

    public GamificationActivityRecord() {
    }

	public GamificationActivityRecord(int id, Users user, String idempotencyKey, @Size(max = 155, message = "Short description should have no more than 155 characters") String shortDescription,
			int awardedXp, Timestamp occurredAt,
			boolean qualifiesForStreak, boolean qualifiesForLeaderboard, GamificationActivitySource sourceType,
			GamificationActivityType activityType, GamificationXpCategory xpCategory, String countryCode,
			String universityId) {
		super();
		this.id = id;
		this.user = user;
		this.idempotencyKey = idempotencyKey;
		this.shortDescription = shortDescription;
		this.awardedXp = awardedXp;
		this.occurredAt = occurredAt;
		this.qualifiesForStreak = qualifiesForStreak;
		this.qualifiesForLeaderboard = qualifiesForLeaderboard;
		this.sourceType = sourceType;
		this.activityType = activityType;
		this.xpCategory = xpCategory;
		this.countryCode = countryCode;
		this.universityId = universityId;
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
	
	public String getIdempotencyKey() {
		return idempotencyKey;
	}

	public void setIdempotencyKey(String idempotencyKey) {
		this.idempotencyKey = idempotencyKey;
	}

	public int getAwardedXp() {
		return awardedXp;
	}

	public void setAwardedXp(int awardedXp) {
		this.awardedXp = awardedXp;
	}

	public Timestamp getOccurredAt() {
		return occurredAt;
	}

	public void setOccurredAt(Timestamp occurredAt) {
		this.occurredAt = occurredAt;
	}

	public boolean isQualifiesForStreak() {
		return qualifiesForStreak;
	}

	public void setQualifiesForStreak(boolean qualifiesForStreak) {
		this.qualifiesForStreak = qualifiesForStreak;
	}

	public boolean isQualifiesForLeaderboard() {
		return qualifiesForLeaderboard;
	}

	public void setQualifiesForLeaderboard(boolean qualifiesForLeaderboard) {
		this.qualifiesForLeaderboard = qualifiesForLeaderboard;
	}

	public GamificationActivitySource getSourceType() {
		return sourceType;
	}

	public void setSourceType(GamificationActivitySource sourceType) {
		this.sourceType = sourceType;
	}

	public GamificationActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(GamificationActivityType activityType) {
		this.activityType = activityType;
	}

	public GamificationXpCategory getXpCategory() {
		return xpCategory;
	}

	public void setXpCategory(GamificationXpCategory xpCategory) {
		this.xpCategory = xpCategory;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getUniversityId() {
		return universityId;
	}

	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
    
}
