package com.infobip.TournamentAPI.api.model;


import java.util.List;

public class WinnerListDTO {

    private List<PlayerPostDTO> winners;

    public WinnerListDTO(List<PlayerPostDTO> winners) {
        this.winners = winners;
    }

    public List<PlayerPostDTO> getWinners() {
        return winners;
    }

    public void setWinners(List<PlayerPostDTO> winners) {
        this.winners = winners;
    }
}
