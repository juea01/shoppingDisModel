package com.shoppingdistrict.microservices.model.dto;

import com.shoppingdistrict.microservices.model.Users;

	public class GamificationActivityEvent {
	
	    private final GamificationActivityType type;
	    private final String idempotencyKey;
	    private final String description;
	    private final GamificationActivitySource source;
	    private final Users user;
	    private final String universityId;
	    private final int awardedXp;
	
	    public GamificationActivityEvent(
	            GamificationActivityType type,
	            String idempotencyKey,
	            String description,
	            GamificationActivitySource source,
	            Users user,
	            String universityId,
	            int awardedXp) {
	
	        this.type = type;
	        this.idempotencyKey = idempotencyKey;
	        this.description = description;
	        this.source = source;
	        this.user = user;
	        this.universityId = universityId;
	        this.awardedXp = awardedXp;
	    }
	
	    public GamificationActivityType getType() {
	        return type;
	    }
	
	    public String getIdempotencyKey() {
	        return idempotencyKey;
	    }
	
	    public String getDescription() {
	        return description;
	    }
	
	    public GamificationActivitySource getSource() {
	        return source;
	    }
	
	    public Users getUser() {
	        return user;
	    }
	
	    public String getUniversityId() {
	        return universityId;
	    }
	
	    public int getAwardedXp() {
	        return awardedXp;
	    }
	}