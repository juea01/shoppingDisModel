package com.shoppingdistrict.microservices.model.dto;

public class GiftCardEligibility {

    private String window;
    private int thresholdXp;
    private int monthlyEarnedXp;
    private int remainingXp;
    private boolean isEligible;
    private String qualifiedAt;

    public GiftCardEligibility() {
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    public int getThresholdXp() {
        return thresholdXp;
    }

    public void setThresholdXp(int thresholdXp) {
        this.thresholdXp = thresholdXp;
    }

    public int getMonthlyEarnedXp() {
        return monthlyEarnedXp;
    }

    public void setMonthlyEarnedXp(int monthlyEarnedXp) {
        this.monthlyEarnedXp = monthlyEarnedXp;
    }

    public int getRemainingXp() {
        return remainingXp;
    }

    public void setRemainingXp(int remainingXp) {
        this.remainingXp = remainingXp;
    }

    public boolean isEligible() {
        return isEligible;
    }

    public void setEligible(boolean eligible) {
        isEligible = eligible;
    }

    public String getQualifiedAt() {
        return qualifiedAt;
    }

    public void setQualifiedAt(String qualifiedAt) {
        this.qualifiedAt = qualifiedAt;
    }
}