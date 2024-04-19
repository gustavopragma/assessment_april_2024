package com.gustavo.pinto.tournamentservice.domain.models;

public class Videogame {
    private String id;
    private String name;
    private Integer numberPlayers;

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

    public Integer getNumberPlayers() {
        return numberPlayers;
    }

    public void setNumberPlayers(Integer numberPlayers) {
        this.numberPlayers = numberPlayers;
    }

    public Boolean getActivate() {
        return isActivate;
    }

    public void setActivate(Boolean activate) {
        isActivate = activate;
    }

    @Override
    public String toString() {
        return "Videogame{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numberPlayers=" + numberPlayers +
                ", isActivate=" + isActivate +
                '}';
    }
}
