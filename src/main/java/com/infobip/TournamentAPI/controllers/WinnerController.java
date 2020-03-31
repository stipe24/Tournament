package com.infobip.TournamentAPI.controllers;

import com.infobip.TournamentAPI.api.model.WinnerListDTO;
import com.infobip.TournamentAPI.services.WinnerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/tournaments/winner", "/tournaments/winner/"})
public class WinnerController {

    private final WinnerService winnerService;

    public WinnerController(WinnerService winnerService) {
        this.winnerService = winnerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public WinnerListDTO getWinners() {
        return new WinnerListDTO(winnerService.getWinners());
    }
}
