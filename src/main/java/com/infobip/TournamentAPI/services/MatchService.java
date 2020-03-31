package com.infobip.TournamentAPI.services;

import com.infobip.TournamentAPI.api.model.MatchDTO;
import com.infobip.TournamentAPI.api.model.MatchGetDTO;
import com.infobip.TournamentAPI.api.model.ResponseDTO;

public interface MatchService {

    MatchGetDTO getMatchById(Integer id);

    ResponseDTO saveMatchByDTO(Integer id, MatchDTO matchDTO);
}
