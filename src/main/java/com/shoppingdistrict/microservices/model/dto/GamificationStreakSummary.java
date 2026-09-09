package com.shoppingdistrict.microservices.model.dto;


public class GamificationStreakSummary {
	
	private int currentDays;
	private int longestDays;
	private String lastQualifiedAt;
	private boolean activeToday;
	
	public GamificationStreakSummary() {

	}

	public GamificationStreakSummary(int currentDays, int longestDays, String lastQualifiedAt, boolean activeToday) {
		super();
		this.currentDays = currentDays;
		this.longestDays = longestDays;
		this.lastQualifiedAt = lastQualifiedAt;
		this.activeToday = activeToday;
	}

	public int getCurrentDays() {
		return currentDays;
	}

	public void setCurrentDays(int currentDays) {
		this.currentDays = currentDays;
	}

	public int getLongestDays() {
		return longestDays;
	}

	public void setLongestDays(int longestDays) {
		this.longestDays = longestDays;
	}

	public String getLastQualifiedAt() {
		return lastQualifiedAt;
	}

	public void setLastQualifiedAt(String lastQualifiedAt) {
		this.lastQualifiedAt = lastQualifiedAt;
	}

	public boolean isActiveToday() {
		return activeToday;
	}

	public void setActiveToday(boolean activeToday) {
		this.activeToday = activeToday;
	}
	
}
