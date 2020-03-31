package com.infobip.TournamentAPI.api.model;

public class PlayerPostDTO {

    private String name;
    private Integer playerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }
}
