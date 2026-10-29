package com.shoppingdistrict.microservices.model.dto;

import java.util.List;

public class GamificationActivityBatchEvent {

	private final List<GamificationActivityEvent> events;

    public GamificationActivityBatchEvent(
            List<GamificationActivityEvent> events) {
        this.events = List.copyOf(events);
    }

    public List<GamificationActivityEvent> getEvents() {
        return events;
    }
}
