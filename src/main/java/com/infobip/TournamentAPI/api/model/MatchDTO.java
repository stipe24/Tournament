package com.infobip.TournamentAPI.api.model;

import com.infobip.TournamentAPI.domain.Player;

import java.util.List;

public class MatchDTO {

    private Integer matchId;
    private String result;
    private List<Player> players;

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
