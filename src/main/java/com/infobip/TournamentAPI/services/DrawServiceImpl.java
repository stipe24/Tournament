package com.infobip.TournamentAPI.services;

import com.infobip.TournamentAPI.api.mapper.MatchMapper;
import com.infobip.TournamentAPI.api.model.MatchDrawDTO;
import com.infobip.TournamentAPI.configuration.TournamentRulesConfig;
import com.infobip.TournamentAPI.domain.Match;
import com.infobip.TournamentAPI.domain.Player;
import com.infobip.TournamentAPI.exceptions.DrawGeneratorException;
import com.infobip.TournamentAPI.exceptions.NotImplementedException;
import com.infobip.TournamentAPI.repositories.MatchRepository;
import com.infobip.TournamentAPI.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DrawServiceImpl implements DrawService {

    private final PlayerRepository playerRepository;
    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;
    private final TournamentRulesConfig tournamentRulesConfig;
    private final Integer NUMBER_OF_PLAYERS;

    public DrawServiceImpl(PlayerRepository playerRepository, MatchRepository matchRepository, MatchMapper matchMapper,
                           TournamentRulesConfig tournamentRulesConfig) {
        this.playerRepository = playerRepository;
        this.matchRepository = matchRepository;
        this.matchMapper = matchMapper;
        this.tournamentRulesConfig = tournamentRulesConfig;
        NUMBER_OF_PLAYERS = tournamentRulesConfig.getNumberOfPlayers();
    }

    @Override
    public List<MatchDrawDTO> generateMatches() {

        if (NUMBER_OF_PLAYERS - tournamentRulesConfig.getNumberOfMatchesPerPlayer() != 3)
            throw new NotImplementedException();

        if (playerRepository.findAll().size() != NUMBER_OF_PLAYERS) {
            throw new DrawGeneratorException();
        }

        matchRepository.deleteAll();
        List<Integer> listPlayerIds = playerRepository.findAll().stream()
                .map(Player::getId)
                .collect(Collectors.toList());

        Set<String> draw = generateRandomMatches(listPlayerIds);
        createAndSaveMatches(draw);

        return matchRepository.findAll().stream()
                .map(matchMapper::matchToMatchDrawDTO)
                .collect(Collectors.toList());
    }

    private Set<String> generateRandomMatches(List<Integer> playerIds) {

        List<Integer> players = shufflePlayers(playerIds);
        Set<String> matches = new HashSet<>();

        for (int i = 0; i < NUMBER_OF_PLAYERS; i++) {
            List<Integer> playerNeighbors = getNeighbors(i);
            for (int j = 0; j < NUMBER_OF_PLAYERS; j++) {
                if (!playerNeighbors.contains(j)) {
                    matches.add(sort(players.get(i), players.get(j)));
                }
            }
        }
        return matches;
    }

    private List<Integer> shufflePlayers(List<Integer> list) {
        Collections.shuffle(list);
        return list;
    }

    private String sort(int i, int j) {
        return i < j ? (i + ":" + j) : (j + ":" + i);
    }


    private void createAndSaveMatches(Set<String> draw) {
        List<Match> matches = new ArrayList<>();

        draw.forEach(m -> {
            int player1Id = Integer.parseInt(m.split(":")[0]);
            int player2Id = Integer.parseInt(m.split(":")[1]);
            Match match = new Match();
            match.getPlayers().add(playerRepository.findById(player1Id).get());
            match.getPlayers().add(playerRepository.findById(player2Id).get());
            matches.add(match);
        });
        matchRepository.saveAll(matches);
    }

    private List<Integer> getNeighbors(Integer index) {

        List<Integer> neighbors = new ArrayList<>();
        neighbors.add(index);
        if (index - 1 < 0)
            neighbors.add(NUMBER_OF_PLAYERS - 1);
        else
            neighbors.add(index - 1);

        if (index + 1 == NUMBER_OF_PLAYERS)
            neighbors.add(0);
        else
            neighbors.add(index + 1);

        return neighbors;
    }
}
