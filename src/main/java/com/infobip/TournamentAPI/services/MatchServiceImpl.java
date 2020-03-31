package com.infobip.TournamentAPI.services;

import com.infobip.TournamentAPI.api.mapper.MatchMapper;
import com.infobip.TournamentAPI.api.model.MatchDTO;
import com.infobip.TournamentAPI.api.model.MatchGetDTO;
import com.infobip.TournamentAPI.api.model.ResponseDTO;
import com.infobip.TournamentAPI.configuration.TournamentRulesConfig;
import com.infobip.TournamentAPI.domain.Match;
import com.infobip.TournamentAPI.exceptions.NotFoundException;
import com.infobip.TournamentAPI.repositories.MatchRepository;
import org.springframework.stereotype.Service;

@Service
public class MatchServiceImpl implements MatchService {

    private final MatchRepository matchRepository;
    private final MatchMapper matchMapper;
    private final TournamentRulesConfig tournamentRulesConfig;

    public MatchServiceImpl(MatchRepository matchRepository, MatchMapper matchMapper, TournamentRulesConfig tournamentRulesConfig) {
        this.matchRepository = matchRepository;
        this.matchMapper = matchMapper;
        this.tournamentRulesConfig = tournamentRulesConfig;
    }

    @Override
    public MatchGetDTO getMatchById(Integer id) {

        return matchRepository.findById(id)
                .map(matchMapper::matchToMatchGetDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public ResponseDTO saveMatchByDTO(Integer id, MatchDTO matchDTO) {

        ResponseDTO responseDTO = new ResponseDTO();
        if (tournamentRulesConfig.getAllowedResults().contains(matchDTO.getResult())) {
            if (matchRepository.findById(id).isPresent()) {
                Match storedMatch = matchRepository.findById(id).get();
                storedMatch.setResult(matchDTO.getResult());
                matchRepository.save(storedMatch);
                responseDTO.setMessage("Score registered");
                return responseDTO;
            }
            throw new NotFoundException();
        }
        responseDTO.setMessage("Invalid score provided");
        return responseDTO;
    }
}
