package com.infobip.TournamentAPI.api.mapper;

import com.infobip.TournamentAPI.api.model.MatchDrawDTO;
import com.infobip.TournamentAPI.api.model.MatchGetDTO;
import com.infobip.TournamentAPI.domain.Match;

public interface MatchMapper {

    MatchGetDTO matchToMatchGetDTO(Match match);

    MatchDrawDTO matchToMatchDrawDTO(Match match);
}
