package com.infobip.TournamentAPI.services;

import com.infobip.TournamentAPI.api.model.PlayerPostDTO;

import java.util.List;

public interface WinnerService {

    List<PlayerPostDTO> getWinners();
}
