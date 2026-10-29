package com.shoppingdistrict.microservices.model.dto;

public class LeaderboardWindowStats {

    private LeaderboardWindow window;
    private int earnedXp;
    private int qualifyingActivityCount;
    private String latestActivityAt;
    private LeaderboardSortKey sortKey;

    public LeaderboardWindowStats() {
    }

    public LeaderboardWindow getWindow() {
        return window;
    }

    public void setWindow(LeaderboardWindow window) {
        this.window = window;
    }

    public int getEarnedXp() {
        return earnedXp;
    }

    public void setEarnedXp(int earnedXp) {
        this.earnedXp = earnedXp;
    }

    public int getQualifyingActivityCount() {
        return qualifyingActivityCount;
    }

    public void setQualifyingActivityCount(int qualifyingActivityCount) {
        this.qualifyingActivityCount = qualifyingActivityCount;
    }

    public String getLatestActivityAt() {
        return latestActivityAt;
    }

    public void setLatestActivityAt(String latestActivityAt) {
        this.latestActivityAt = latestActivityAt;
    }

    public LeaderboardSortKey getSortKey() {
        return sortKey;
    }

    public void setSortKey(LeaderboardSortKey sortKey) {
        this.sortKey = sortKey;
    }
}