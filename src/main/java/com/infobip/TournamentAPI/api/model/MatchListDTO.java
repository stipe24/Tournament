package com.infobip.TournamentAPI.api.model;

import java.util.List;

public class MatchListDTO {

    private List<MatchDrawDTO> matches;

    public MatchListDTO(List<MatchDrawDTO> matches) {
        this.matches = matches;
    }

    public List<MatchDrawDTO> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchDrawDTO> matches) {
        this.matches = matches;
    }
}
