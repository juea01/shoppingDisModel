package com.shoppingdistrict.microservices.model.dto;

import java.util.List;

public class GamificationAchievementProfilePayload {

	private int userId;
	private String stableUserId;
	private String username;
	private String displayName;
	private List<UserPrivacySetting> privacySettings;
	private List<GamificationActivityRecord> activities;
	private Progress progress;

	public GamificationAchievementProfilePayload() {

	}

	public GamificationAchievementProfilePayload(int userId, String stableUserId, String username, String displayName,
			 List<UserPrivacySetting> privacySettings, List<GamificationActivityRecord> activities, Progress progress) {
		super();
		this.userId = userId;
		this.stableUserId = stableUserId;
		this.username = username;
		this.displayName = displayName;
		this.privacySettings = privacySettings;
		this.activities = activities;
		this.progress = progress;
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

	public Progress getProgress() {
		return progress;
	}

	public void setProgress(Progress progress) {
		this.progress = progress;
	}

}