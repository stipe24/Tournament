package com.infobip.TournamentAPI.services;

import com.infobip.TournamentAPI.api.model.MatchDrawDTO;

import java.util.List;

public interface DrawService {

    List<MatchDrawDTO> generateMatches();
}
