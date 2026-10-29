package com.shoppingdistrict.microservices.model.dto;

import java.util.List;
import com.shoppingdistrict.microservices.model.GamificationActivityRecord;

public class GamificationActivityBatchRequest {
	 private List<GamificationActivityRecord> activities;

	    public GamificationActivityBatchRequest() {
	    }

	    public List<GamificationActivityRecord> getActivities() {
	        return activities;
	    }

	    public void setActivities(
	            List<GamificationActivityRecord> activities) {
	        this.activities = activities;
	    }
}
