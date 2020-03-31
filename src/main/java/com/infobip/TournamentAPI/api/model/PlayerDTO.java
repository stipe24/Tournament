package com.infobip.TournamentAPI.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerDTO {

    private Integer playerId;
    private String name;
    @JsonProperty
    private Integer age;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
