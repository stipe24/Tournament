package com.infobip.TournamentAPI.controllers;

import com.infobip.TournamentAPI.api.model.MatchDTO;
import com.infobip.TournamentAPI.api.model.MatchGetDTO;
import com.infobip.TournamentAPI.api.model.ResponseDTO;
import com.infobip.TournamentAPI.services.MatchService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/tournaments/results/"})
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatchGetDTO getMatchById(@PathVariable Integer id) {
        return matchService.getMatchById(id);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseDTO> updateMatch(@PathVariable Integer id, @RequestBody MatchDTO matchDTO) {

        ResponseDTO responseDTO = matchService.saveMatchByDTO(id, matchDTO);
        if (responseDTO.getMessage().equals("Invalid score provided")) {
            return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
