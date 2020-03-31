package com.infobip.TournamentAPI.services;

import com.infobip.TournamentAPI.api.mapper.PlayerMapper;
import com.infobip.TournamentAPI.api.model.PlayerDTO;
import com.infobip.TournamentAPI.api.model.PlayerPostDTO;
import com.infobip.TournamentAPI.configuration.TournamentRulesConfig;
import com.infobip.TournamentAPI.domain.Player;
import com.infobip.TournamentAPI.exceptions.InvalidPlayersSizeException;
import com.infobip.TournamentAPI.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;
    private final TournamentRulesConfig tournamentRulesConfig;

    public PlayerServiceImpl(PlayerRepository playerRepository, PlayerMapper playerMapper, TournamentRulesConfig tournamentRulesConfig) {
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
        this.tournamentRulesConfig = tournamentRulesConfig;
    }

    @Override
    public PlayerPostDTO createNewPlayer(PlayerDTO playerDTO) {

        if (playerRepository.findAll().size() < tournamentRulesConfig.getNumberOfPlayers()) {
            Player player = playerMapper.playerDTOToPlayer(playerDTO);
            Player savedPlayer = playerRepository.save(player);
            return playerMapper.playerToPlayerPostDTO(savedPlayer);
        }
        throw new InvalidPlayersSizeException();
    }
}
