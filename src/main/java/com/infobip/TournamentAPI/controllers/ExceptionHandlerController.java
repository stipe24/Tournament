package com.infobip.TournamentAPI.controllers;

import com.infobip.TournamentAPI.api.model.ResponseDTO;
import com.infobip.TournamentAPI.configuration.TournamentRulesConfig;
import com.infobip.TournamentAPI.exceptions.DrawGeneratorException;
import com.infobip.TournamentAPI.exceptions.InvalidPlayersSizeException;
import com.infobip.TournamentAPI.exceptions.NotFoundException;
import com.infobip.TournamentAPI.exceptions.NotImplementedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionHandlerController extends org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler {

    private final TournamentRulesConfig tournamentRulesConfig;

    public ExceptionHandlerController(TournamentRulesConfig tournamentRulesConfig) {
        this.tournamentRulesConfig = tournamentRulesConfig;
    }

    @ExceptionHandler({InvalidPlayersSizeException.class})
    public ResponseEntity<Object> handleInvalidPlayerValueException(Exception exception, WebRequest webRequest) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Can not store more than " + tournamentRulesConfig.getNumberOfPlayers() + " players");
        return new ResponseEntity<>(responseDTO, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DrawGeneratorException.class})
    public ResponseEntity<Object> handleDrawGenerationException(Exception exception, WebRequest webRequest) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Can not generate matches: less than " + tournamentRulesConfig.getNumberOfPlayers() + " players");
        return new ResponseEntity<>(responseDTO, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(Exception exception, WebRequest webRequest) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Not found");
        return new ResponseEntity<>(responseDTO, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NotImplementedException.class})
    public ResponseEntity<Object> handleNotImplementedException(Exception exception, WebRequest webRequest) {
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Not implemented");
        return new ResponseEntity<>(responseDTO, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
