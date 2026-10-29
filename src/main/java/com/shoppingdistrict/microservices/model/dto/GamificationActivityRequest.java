package com.shoppingdistrict.microservices.model.dto;

import com.shoppingdistrict.microservices.model.Users;
import com.shoppingdistrict.microservices.model.dto.GamificationActivitySource;
import com.shoppingdistrict.microservices.model.dto.GamificationActivityType;

public class GamificationActivityRequest {

    private GamificationActivityType type;
    private GamificationActivitySource source;
    private Users user;
    private String universityId;
    private int awardedXp;
    private String sourceName;
    private Integer[] sourceIds;

    public GamificationActivityType getType() {
        return type;
    }

    public void setType(GamificationActivityType type) {
        this.type = type;
    }

    public GamificationActivitySource getSource() {
        return source;
    }

    public void setSource(GamificationActivitySource source) {
        this.source = source;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getAwardedXp() {
        return awardedXp;
    }

    public void setAwardedXp(int awardedXp) {
        this.awardedXp = awardedXp;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public Integer[] getSourceIds() {
        return sourceIds;
    }

    public void setSourceIds(Integer... sourceIds) {
        this.sourceIds = sourceIds;
    }
}
