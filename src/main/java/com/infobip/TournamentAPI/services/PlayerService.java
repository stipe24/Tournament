package com.infobip.TournamentAPI.services;

import com.infobip.TournamentAPI.api.model.PlayerDTO;
import com.infobip.TournamentAPI.api.model.PlayerPostDTO;

public interface PlayerService {

    PlayerPostDTO createNewPlayer(PlayerDTO playerDTO);
}
