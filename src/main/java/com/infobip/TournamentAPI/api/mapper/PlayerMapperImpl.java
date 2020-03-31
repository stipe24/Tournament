package com.infobip.TournamentAPI.api.mapper;

import com.infobip.TournamentAPI.api.model.PlayerDTO;
import com.infobip.TournamentAPI.api.model.PlayerPostDTO;
import com.infobip.TournamentAPI.domain.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapperImpl implements PlayerMapper {
    @Override
    public Player playerDTOToPlayer(PlayerDTO playerDTO) {

        if (playerDTO == null) {
            return null;
        }

        Player player = new Player();
        player.setId(playerDTO.getPlayerId());
        player.setName(playerDTO.getName());
        player.setAge(playerDTO.getAge());

        return player;
    }

    @Override
    public PlayerPostDTO playerToPlayerPostDTO(Player player) {

        if (player == null) {
            return null;
        }

        PlayerPostDTO playerPostDTO = new PlayerPostDTO();
        playerPostDTO.setPlayerId(player.getId());
        playerPostDTO.setName(player.getName());

        return playerPostDTO;
    }
}
