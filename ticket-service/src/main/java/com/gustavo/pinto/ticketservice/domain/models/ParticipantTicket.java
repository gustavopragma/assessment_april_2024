package com.gustavo.pinto.ticketservice.domain.models;

import java.time.LocalDate;

public class ParticipantTicket {
    private String id;
    private String tournamentId;
    private String clientId;
    private Float price;
    private Boolean isActivate;
    private LocalDate createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getActivate() {
        return isActivate;
    }

    public void setActivate(Boolean activate) {
        isActivate = activate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "ParticipantTicket{" +
                "id='" + id + '\'' +
                ", tournamentId='" + tournamentId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", price=" + price +
                ", isActivate=" + isActivate +
                ", createdAt=" + createdAt +
                '}';
    }
}
