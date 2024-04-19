package com.gustavo.pinto.tournamentservice.domain.models;

public class Streaming {
    private String id;
    private String platform;
    private String url;
    private Boolean isActivate;
    private Tournament tournament;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getActivate() {
        return isActivate;
    }

    public void setActivate(Boolean activate) {
        isActivate = activate;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    @Override
    public String toString() {
        return "Streaming{" +
                "id=" + id +
                ", platform='" + platform + '\'' +
                ", url='" + url + '\'' +
                ", isActivate=" + isActivate +
                '}';
    }
}
