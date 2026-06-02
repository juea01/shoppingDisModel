package com.shoppingdistrict.microservices.model.dto;

import java.util.List;

public class GamificationLeaderboardPayloadEntry {

	private int userId;
	private String stableUserId;
	private String username;
	private String displayName;

	private int badgeCount;

	private List<UserPrivacySetting> privacySettings;
	private List<GamificationActivityRecord> activities;

	public GamificationLeaderboardPayloadEntry() {

	}

	public GamificationLeaderboardPayloadEntry(int userId, String stableUserId, String username, String displayName,
			int badgeCount, List<UserPrivacySetting> privacySettings, List<GamificationActivityRecord> activities) {
		super();
		this.userId = userId;
		this.stableUserId = stableUserId;
		this.username = username;
		this.displayName = displayName;
		this.badgeCount = badgeCount;
		this.privacySettings = privacySettings;
		this.activities = activities;
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

	public int getBadgeCount() {
		return badgeCount;
	}

	public void setBadgeCount(int badgeCount) {
		this.badgeCount = badgeCount;
	}

	public List<UserPrivacySetting> getPrivacySettings() {
		return privacySettings;
	}

	public void setPrivacySettings(List<UserPrivacySetting> privacySettings) {
		this.privacySettings = privacySettings;
	}

	public List<GamificationActivityRecord> getActivities() {
		return activities;
	}

	public void setActivities(List<GamificationActivityRecord> activities) {
		this.activities = activities;
	}

	
}