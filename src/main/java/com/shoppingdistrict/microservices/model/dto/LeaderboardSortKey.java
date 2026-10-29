package com.shoppingdistrict.microservices.model.dto;

public class LeaderboardSortKey {

    private int earnedXp;
    private String latestActivityAt;
    private String stableUserId;

    public LeaderboardSortKey() {
    }

    public int getEarnedXp() {
        return earnedXp;
    }

    public void setEarnedXp(int earnedXp) {
        this.earnedXp = earnedXp;
    }

    public String getLatestActivityAt() {
        return latestActivityAt;
    }

    public void setLatestActivityAt(String latestActivityAt) {
        this.latestActivityAt = latestActivityAt;
    }

    public String getStableUserId() {
        return stableUserId;
    }

    public void setStableUserId(String stableUserId) {
        this.stableUserId = stableUserId;
    }
}
