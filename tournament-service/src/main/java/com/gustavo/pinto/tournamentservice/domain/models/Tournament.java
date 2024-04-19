package com.gustavo.pinto.tournamentservice.domain.models;

import java.time.LocalDate;
import java.util.List;

public class Tournament {
    private String id;
    private String name;
    private Integer participantsLimit;
    private Float presalePriceParticipant;
    private Float salePriceParticipant;
    private Float presalePriceSpectator;
    private Float salePriceSpectator;
    private LocalDate presaleParticipantEndDate;
    private LocalDate presaleSpectatorEndDate;
    private LocalDate createdAt;
    private Boolean isActivate;
    private String ownerId;
    private Videogame videogame;
    private Category category;
    private List<Streaming> streamings;

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

    public Integer getParticipantsLimit() {
        return participantsLimit;
    }

    public void setParticipantsLimit(Integer participantsLimit) {
        this.participantsLimit = participantsLimit;
    }

    public Float getPresalePriceParticipant() {
        return presalePriceParticipant;
    }

    public void setPresalePriceParticipant(Float presalePriceParticipant) {
        this.presalePriceParticipant = presalePriceParticipant;
    }

    public Float getSalePriceParticipant() {
        return salePriceParticipant;
    }

    public void setSalePriceParticipant(Float salePriceParticipant) {
        this.salePriceParticipant = salePriceParticipant;
    }

    public Float getPresalePriceSpectator() {
        return presalePriceSpectator;
    }

    public void setPresalePriceSpectator(Float presalePriceSpectator) {
        this.presalePriceSpectator = presalePriceSpectator;
    }

    public Float getSalePriceSpectator() {
        return salePriceSpectator;
    }

    public void setSalePriceSpectator(Float salePriceSpectator) {
        this.salePriceSpectator = salePriceSpectator;
    }

    public LocalDate getPresaleParticipantEndDate() {
        return presaleParticipantEndDate;
    }

    public void setPresaleParticipantEndDate(LocalDate presaleParticipantEndDate) {
        this.presaleParticipantEndDate = presaleParticipantEndDate;
    }

    public LocalDate getPresaleSpectatorEndDate() {
        return presaleSpectatorEndDate;
    }

    public void setPresaleSpectatorEndDate(LocalDate presaleSpectatorEndDate) {
        this.presaleSpectatorEndDate = presaleSpectatorEndDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getActivate() {
        return isActivate;
    }

    public void setActivate(Boolean activate) {
        isActivate = activate;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public Videogame getVideogame() {
        return videogame;
    }

    public void setVideogame(Videogame videogame) {
        this.videogame = videogame;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Streaming> getStreamings() {
        return streamings;
    }

    public void setStreamings(List<Streaming> streamings) {
        this.streamings = streamings;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", participantsLimit=" + participantsLimit +
                ", presalePriceParticipant=" + presalePriceParticipant +
                ", salePriceParticipant=" + salePriceParticipant +
                ", presalePriceSpectator=" + presalePriceSpectator +
                ", salePriceSpectator=" + salePriceSpectator +
                ", presaleParticipantEndDate=" + presaleParticipantEndDate +
                ", presaleSpectatorEndDate=" + presaleSpectatorEndDate +
                ", createdAt=" + createdAt +
                ", isActivate=" + isActivate +
                ", ownerId='" + ownerId + '\'' +
                ", videogame=" + videogame +
                ", category=" + category +
                '}';
    }
}
