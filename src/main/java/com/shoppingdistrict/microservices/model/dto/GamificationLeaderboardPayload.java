package com.shoppingdistrict.microservices.model.dto;

import java.util.List;

public class GamificationLeaderboardPayload {

	private List<GamificationLeaderboardPayloadEntry> entries;

	public GamificationLeaderboardPayload() {
	}

	public GamificationLeaderboardPayload(List<GamificationLeaderboardPayloadEntry> entries) {
		super();
		this.entries = entries;
	}

	public List<GamificationLeaderboardPayloadEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<GamificationLeaderboardPayloadEntry> entries) {
		this.entries = entries;
	}
	
}