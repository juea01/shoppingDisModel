package com.shoppingdistrict.microservices.model.dto;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ActivityXpBreakdownLabel {

    QUESTIONS("Questions"),
    EXERCISES("Exercises"),
    LECTURES("Lectures"),
    COURSES("Courses"),
    STREAK_BONUSES("Streak bonuses"),
    OTHERS("Others");

    private final String label;

    ActivityXpBreakdownLabel(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }
}
