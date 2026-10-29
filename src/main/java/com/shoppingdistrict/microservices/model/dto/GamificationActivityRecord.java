package com.shoppingdistrict.microservices.model.dto;

public class GamificationActivityRecord {

	private String activityId;
	private int userId;
	private String stableUserId;
	private String idempotencyKey;
	private String username;
	private String displayName;

	private String shortDescription;
	
	private int awardedXp;
	private String occurredAt;
	
	private boolean qualifiesForStreak;
	private boolean qualifiesForLeaderboard;

	private GamificationActivitySource sourceType;
	private GamificationActivityType activityType;
	private GamificationXpCategory xpCategory;
	private int sourceId;

	private int badgeCount;

	private String countryCode;
	private String universityId;

	public GamificationActivityRecord() {

	}

	public GamificationActivityRecord(String activityId, int userId, String stableUserId, String idempotencyKey, String username,
			String displayName, String shortDescription, int awardedXp, String occurredAt, boolean qualifiesForStreak,
			boolean qualifiesForLeaderboard, GamificationActivitySource sourceType, int sourceId, int badgeCount,
			String countryCode, String universityId) {
		super();
		this.activityId = activityId;
		this.userId = userId;
		this.stableUserId = stableUserId;
		this.idempotencyKey = idempotencyKey;
		this.username = username;
		this.displayName = displayName;
		this.shortDescription = shortDescription;
		this.awardedXp = awardedXp;
		this.occurredAt = occurredAt;
		this.qualifiesForStreak = qualifiesForStreak;
		this.qualifiesForLeaderboard = qualifiesForLeaderboard;
		this.sourceType = sourceType;
		this.sourceId = sourceId;
		this.badgeCount = badgeCount;
		this.countryCode = countryCode;
		this.universityId = universityId;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStableUserId() {
		return stableUserId;
	}

	public void setStableUserId(String stableUserId) {
		this.stableUserId = stableUserId;
	}
	
	public String getIdempotencyKey() {
		return idempotencyKey;
	}

	public void setIdempotencyKey(String idempotencyKey) {
		this.idempotencyKey = idempotencyKey;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public int getAwardedXp() {
		return awardedXp;
	}

	public void setAwardedXp(int awardedXp) {
		this.awardedXp = awardedXp;
	}

	public String getOccurredAt() {
		return occurredAt;
	}

	public void setOccurredAt(String occurredAt) {
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

	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public int getBadgeCount() {
		return badgeCount;
	}

	public void setBadgeCount(int badgeCount) {
		this.badgeCount = badgeCount;
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