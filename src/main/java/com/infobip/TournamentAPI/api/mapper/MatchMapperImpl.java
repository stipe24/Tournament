package com.infobip.TournamentAPI.api.mapper;

import com.infobip.TournamentAPI.api.model.MatchDrawDTO;
import com.infobip.TournamentAPI.api.model.MatchGetDTO;
import com.infobip.TournamentAPI.domain.Match;
import org.springframework.stereotype.Component;

@Component
public class MatchMapperImpl implements MatchMapper {

    @Override
    public MatchGetDTO matchToMatchGetDTO(Match match) {

        if (match == null) {
            return null;
        }

        MatchGetDTO matchGetDTO = new MatchGetDTO();
        matchGetDTO.setFirstPlayer(match.getPlayers().get(0).getName());
        matchGetDTO.setSecondPlayer(match.getPlayers().get(1).getName());
        matchGetDTO.setResult(match.getResult());

        return matchGetDTO;
    }

    @Override
    public MatchDrawDTO matchToMatchDrawDTO(Match match) {

        if (match == null) {
            return null;
        }

        MatchDrawDTO matchDrawDTO = new MatchDrawDTO();
        matchDrawDTO.setFirstPlayerId(match.getPlayers().get(0).getId());
        matchDrawDTO.setSecondPlayerId(match.getPlayers().get(1).getId());
        matchDrawDTO.setMatchId(match.getId());

        return matchDrawDTO;
    }
}
