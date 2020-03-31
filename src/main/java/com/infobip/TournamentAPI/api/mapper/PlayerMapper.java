package com.infobip.TournamentAPI.api.mapper;

import com.infobip.TournamentAPI.api.model.PlayerDTO;
import com.infobip.TournamentAPI.api.model.PlayerPostDTO;
import com.infobip.TournamentAPI.domain.Player;

public interface PlayerMapper {

    Player playerDTOToPlayer(PlayerDTO playerDTO);

    PlayerPostDTO playerToPlayerPostDTO(Player player);
}
