package com.shoppingdistrict.microservices.model.dto;

public class LeaderboardStats {

    private LeaderboardWindowStats weekly;
    private LeaderboardWindowStats monthly;
    private LeaderboardWindowStats allTime;

    public LeaderboardStats() {
    }

    public LeaderboardWindowStats getWeekly() {
        return weekly;
    }

    public void setWeekly(LeaderboardWindowStats weekly) {
        this.weekly = weekly;
    }

    public LeaderboardWindowStats getMonthly() {
        return monthly;
    }

    public void setMonthly(LeaderboardWindowStats monthly) {
        this.monthly = monthly;
    }

    public LeaderboardWindowStats getAllTime() {
        return allTime;
    }

    public void setAllTime(LeaderboardWindowStats allTime) {
        this.allTime = allTime;
    }
}