package com.gustavo.pinto.notificationservice.domain.models;


import java.time.LocalDate;

public class Notification {
    private String id;
    private String ticketId;
    private String ticketType;
    private String tournamentId;
    private Float price;
    private LocalDate createdAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", ticketId='" + ticketId + '\'' +
                ", ticketType='" + ticketType + '\'' +
                ", tournamentId='" + tournamentId + '\'' +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }
}
