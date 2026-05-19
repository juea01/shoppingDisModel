package com.shoppingdistrict.microservices.model.dto;

import java.util.List;

public class GamificationSnapshotPayload {

    private int userId;
    private String stableUserId;
    private String username;
    private Progress progress;
    private List<UserPrivacySetting> privacySettings;
    
    
    
	public GamificationSnapshotPayload() {
		
	}


	public GamificationSnapshotPayload(int userId, String stableUserId, String username, Progress progress,
			List<UserPrivacySetting> privacySettings) {
		super();
		this.userId = userId;
		this.stableUserId = stableUserId;
		this.username = username;
		this.progress = progress;
		this.privacySettings = privacySettings;
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


	public Progress getProgress() {
		return progress;
	}


	public void setProgress(Progress progress) {
		this.progress = progress;
	}


	public List<UserPrivacySetting> getPrivacySettings() {
		return privacySettings;
	}


	public void setPrivacySettings(List<UserPrivacySetting> privacySettings) {
		this.privacySettings = privacySettings;
	}
    
    

}