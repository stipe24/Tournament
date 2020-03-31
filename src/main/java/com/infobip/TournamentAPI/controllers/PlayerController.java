package com.infobip.TournamentAPI.controllers;

import com.infobip.TournamentAPI.api.model.PlayerDTO;
import com.infobip.TournamentAPI.api.model.PlayerPostDTO;
import com.infobip.TournamentAPI.services.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/players", "/players/"})
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public PlayerPostDTO createNewPlayer(@RequestBody PlayerDTO playerDTO) {
        return playerService.createNewPlayer(playerDTO);
    }
}
