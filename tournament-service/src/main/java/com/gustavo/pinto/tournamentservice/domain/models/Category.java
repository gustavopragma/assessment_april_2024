package com.gustavo.pinto.tournamentservice.domain.models;

public class Category {
    private String id;
    private String name;
    private Boolean isFree;
    private Integer participantsLimit;
    private Integer spectatorsLimit;
    private Integer streamingLimit;
    private Integer commissionPercentage;
    private Boolean isActivate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsFree() {
        return isFree;
    }

    public void setIsFree(Boolean free) {
        isFree = free;
    }

    public Integer getParticipantsLimit() {
        return participantsLimit;
    }

    public void setParticipantsLimit(Integer participantsLimit) {
        this.participantsLimit = participantsLimit;
    }

    public Integer getSpectatorsLimit() {
        return spectatorsLimit;
    }

    public void setSpectatorsLimit(Integer spectatorsLimit) {
        this.spectatorsLimit = spectatorsLimit;
    }

    public Integer getStreamingLimit() {
        return streamingLimit;
    }

    public void setStreamingLimit(Integer streamingLimit) {
        this.streamingLimit = streamingLimit;
    }

    public Integer getCommissionPercentage() {
        return commissionPercentage;
    }

    public void setCommissionPercentage(Integer commissionPercentage) {
        this.commissionPercentage = commissionPercentage;
    }

    public Boolean getActivate() {
        return isActivate;
    }

    public void setActivate(Boolean activate) {
        isActivate = activate;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", isFree=" + isFree +
                ", participantsLimit=" + participantsLimit +
                ", spectatorsLimit=" + spectatorsLimit +
                ", streamingLimit=" + streamingLimit +
                ", commissionPercentage=" + commissionPercentage +
                ", isActivate=" + isActivate +
                '}';
    }
}
