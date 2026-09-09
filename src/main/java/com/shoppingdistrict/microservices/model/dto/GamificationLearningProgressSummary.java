package com.shoppingdistrict.microservices.model.dto;

public class GamificationLearningProgressSummary {

    private int userId;
    private String username;
    private Progress progress;
    private GamificationStreakSummary streak;
    
	public GamificationLearningProgressSummary() {
		
	}

	public GamificationLearningProgressSummary(int userId, String username, Progress progress,
			GamificationStreakSummary streak) {
		super();
		this.userId = userId;
		this.username = username;
		this.progress = progress;
		this.streak = streak;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public GamificationStreakSummary getStreak() {
		return streak;
	}

	public void setStreak(GamificationStreakSummary streak) {
		this.streak = streak;
	}
	    
}