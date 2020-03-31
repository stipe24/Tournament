package com.infobip.TournamentAPI.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Match extends BaseEntity {

    private String result;

    @ManyToMany
    @JoinTable(name = "draw",
            joinColumns = @JoinColumn(name = "match_id"), inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<Player> players = new ArrayList<>();

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
