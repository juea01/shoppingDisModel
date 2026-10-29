package com.shoppingdistrict.microservices.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActivityXpViewModel {

    private int monthlyXp;

    private int currentStreakDays;

    private int remainingXpForGiftCard;

    @JsonProperty("isGiftCardEligible")
    private boolean isGiftCardEligible;

    private List<ActivityXpBreakdownItem> breakdown;

    private List<ActivityXpTrendPoint> trend;

    @JsonProperty("hasMeaningfulTrend")
    private boolean hasMeaningfulTrend;

    /**
     * Without JsonProperty annotation, JSON data sent across network would has property name like sparseHistory
     * even though given name is isSparseHistory.
     */
    @JsonProperty("isSparseHistory")
    private boolean isSparseHistory;

    @JsonProperty("isNewLearner")
    private boolean isNewLearner;

    private List<GamificationActivityRecord> activityFeed;

    public ActivityXpViewModel() {
    }

    public int getMonthlyXp() {
        return monthlyXp;
    }

    public void setMonthlyXp(int monthlyXp) {
        this.monthlyXp = monthlyXp;
    }

    public int getCurrentStreakDays() {
        return currentStreakDays;
    }

    public void setCurrentStreakDays(int currentStreakDays) {
        this.currentStreakDays = currentStreakDays;
    }

    public int getRemainingXpForGiftCard() {
        return remainingXpForGiftCard;
    }

    public void setRemainingXpForGiftCard(int remainingXpForGiftCard) {
        this.remainingXpForGiftCard = remainingXpForGiftCard;
    }

    public boolean isGiftCardEligible() {
        return isGiftCardEligible;
    }

    public void setGiftCardEligible(boolean giftCardEligible) {
        isGiftCardEligible = giftCardEligible;
    }

    public List<ActivityXpBreakdownItem> getBreakdown() {
        return breakdown;
    }

    public void setBreakdown(
            List<ActivityXpBreakdownItem> breakdown) {

        this.breakdown = breakdown;
    }

    public List<ActivityXpTrendPoint> getTrend() {
        return trend;
    }

    public void setTrend(
            List<ActivityXpTrendPoint> trend) {

        this.trend = trend;
    }

    public boolean isHasMeaningfulTrend() {
        return hasMeaningfulTrend;
    }

    public void setHasMeaningfulTrend(
            boolean hasMeaningfulTrend) {

        this.hasMeaningfulTrend = hasMeaningfulTrend;
    }

    public boolean isSparseHistory() {
        return isSparseHistory;
    }

    public void setSparseHistory(
            boolean sparseHistory) {

        isSparseHistory = sparseHistory;
    }

    public boolean isNewLearner() {
        return isNewLearner;
    }

    public void setNewLearner(
            boolean newLearner) {

        isNewLearner = newLearner;
    }

    public List<GamificationActivityRecord> getActivityFeed() {
        return activityFeed;
    }

    public void setActivityFeed(
            List<GamificationActivityRecord> activityFeed) {

        this.activityFeed = activityFeed;
    }
}