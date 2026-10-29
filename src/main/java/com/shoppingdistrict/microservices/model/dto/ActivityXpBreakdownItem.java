package com.shoppingdistrict.microservices.model.dto;

public class ActivityXpBreakdownItem {

    private ActivityXpBreakdownLabel label;
    private int earnedXp;
    private int activityCount;

    public ActivityXpBreakdownItem() {
    }

    public ActivityXpBreakdownLabel getLabel() {
        return label;
    }

    public void setLabel(ActivityXpBreakdownLabel label) {
        this.label = label;
    }

    public int getEarnedXp() {
        return earnedXp;
    }

    public void setEarnedXp(int earnedXp) {
        this.earnedXp = earnedXp;
    }

    public int getActivityCount() {
        return activityCount;
    }

    public void setActivityCount(int activityCount) {
        this.activityCount = activityCount;
    }
}
