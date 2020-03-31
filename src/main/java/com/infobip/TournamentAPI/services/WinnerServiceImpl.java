package com.infobip.TournamentAPI.services;

import com.infobip.TournamentAPI.api.mapper.PlayerMapper;
import com.infobip.TournamentAPI.api.model.PlayerPostDTO;
import com.infobip.TournamentAPI.configuration.TournamentRulesConfig;
import com.infobip.TournamentAPI.domain.Match;
import com.infobip.TournamentAPI.domain.Player;
import com.infobip.TournamentAPI.repositories.MatchRepository;
import com.infobip.TournamentAPI.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WinnerServiceImpl implements WinnerService {

    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;
    private final PlayerMapper playerMapper;
    private final TournamentRulesConfig tournamentRulesConfig;

    public WinnerServiceImpl(MatchRepository matchRepository, PlayerRepository playerRepository, PlayerMapper playerMapper, TournamentRulesConfig tournamentRulesConfig) {
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
        this.playerMapper = playerMapper;
        this.tournamentRulesConfig = tournamentRulesConfig;
    }

    @Override
    public List<PlayerPostDTO> getWinners() {

        Map<Integer, Integer> allPoints = calculatePoints();
        return getWinners(allPoints);
    }

    private Map<Integer, Integer> calculatePoints() {

        Map<Integer, Integer> playerPoints = new HashMap<>();
        List<Match> allMatches = matchRepository.findAll();
        int winnerPoints = tournamentRulesConfig.getWinningPoints();
        int looserPoints = tournamentRulesConfig.getLossPoints();

        for (Match match : allMatches) {
            String result = match.getResult();
            if (result != null) {
                int player1Id = match.getPlayers().get(0).getId();
                int player2Id = match.getPlayers().get(1).getId();
                int result1 = Integer.parseInt(result.split(":")[0]);
                int result2 = Integer.parseInt(result.split(":")[1]);
                playerPoints.putIfAbsent(player1Id, 0);
                playerPoints.putIfAbsent(player2Id, 0);
                if (result1 > result2) {
                    playerPoints.put(player1Id, playerPoints.get(player1Id) + winnerPoints);
                    playerPoints.put(player2Id, playerPoints.get(player2Id) + looserPoints);
                } else {
                    playerPoints.put(player1Id, playerPoints.get(player1Id) + looserPoints);
                    playerPoints.put(player2Id, playerPoints.get(player2Id) + winnerPoints);
                }
            }
        }
        return playerPoints;
    }

    private List<PlayerPostDTO> getWinners(Map<Integer, Integer> pointsMap) {

        List<PlayerPostDTO> winners = new ArrayList<>();
        if (!pointsMap.isEmpty()) {
            Integer maxPoints = Collections.max(pointsMap.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
            pointsMap.forEach((playerId, points) -> {
                if (points.equals(maxPoints)) {
                    Optional<Player> player = playerRepository.findById(playerId);
                    if (player.isPresent()) {
                        winners.add(playerMapper.playerToPlayerPostDTO(player.get()));
                    }
                }
            });
        }
        return winners;
    }
}
