package com.shoppingdistrict.microservices.model.dto;

import java.util.List;

public class GamificationSnapshot {

    private int userId;
    private String stableUserId;
    private String username;

    private GamificationTotals totals;

    private GamificationProgressSummary progress;

    private GamificationStreakSummary streak;

    private LeaderboardStats leaderboard;

    private GiftCardEligibility giftCardEligibility;

    private List<GamificationActivityRecord> recentActivity;

    public GamificationSnapshot() {
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

    public GamificationTotals getTotals() {
        return totals;
    }

    public void setTotals(GamificationTotals totals) {
        this.totals = totals;
    }

    public GamificationProgressSummary getProgress() {
        return progress;
    }

    public void setProgress(GamificationProgressSummary progress) {
        this.progress = progress;
    }

    public GamificationStreakSummary getStreak() {
        return streak;
    }

    public void setStreak(GamificationStreakSummary streak) {
        this.streak = streak;
    }

    public LeaderboardStats getLeaderboard() {
        return leaderboard;
    }

    public void setLeaderboard(LeaderboardStats leaderboard) {
        this.leaderboard = leaderboard;
    }

    public GiftCardEligibility getGiftCardEligibility() {
        return giftCardEligibility;
    }

    public void setGiftCardEligibility(
            GiftCardEligibility giftCardEligibility) {

        this.giftCardEligibility = giftCardEligibility;
    }

    public List<GamificationActivityRecord> getRecentActivity() {
        return recentActivity;
    }

    public void setRecentActivity(
            List<GamificationActivityRecord> recentActivity) {

        this.recentActivity = recentActivity;
    }
}
