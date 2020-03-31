package com.infobip.TournamentAPI.controllers;

import com.infobip.TournamentAPI.api.model.MatchListDTO;
import com.infobip.TournamentAPI.services.DrawService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/tournaments/draw", "/tournaments/draw/"})
public class DrawController {

    private final DrawService drawService;

    public DrawController(DrawService drawService) {
        this.drawService = drawService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public MatchListDTO generateMatches() {
        return new MatchListDTO(drawService.generateMatches());
    }
}
