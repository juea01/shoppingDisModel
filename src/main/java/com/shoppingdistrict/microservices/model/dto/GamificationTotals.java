package com.shoppingdistrict.microservices.model.dto;

public class GamificationTotals {

    private int earnedXp;
    private int monthlyXp;
    private int completedQuestions;
    private int qualifyingActivityCount;

    public GamificationTotals() {
    }

    public int getEarnedXp() {
        return earnedXp;
    }

    public void setEarnedXp(int earnedXp) {
        this.earnedXp = earnedXp;
    }

    public int getMonthlyXp() {
        return monthlyXp;
    }

    public void setMonthlyXp(int monthlyXp) {
        this.monthlyXp = monthlyXp;
    }

    public int getCompletedQuestions() {
        return completedQuestions;
    }

    public void setCompletedQuestions(int completedQuestions) {
        this.completedQuestions = completedQuestions;
    }

    public int getQualifyingActivityCount() {
        return qualifyingActivityCount;
    }

    public void setQualifyingActivityCount(int qualifyingActivityCount) {
        this.qualifyingActivityCount = qualifyingActivityCount;
    }
}
