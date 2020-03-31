package com.infobip.TournamentAPI.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "tournament-rules")
public class TournamentRulesConfig {

    private Integer numberOfPlayers;
    private Integer numberOfMatchesPerPlayer;
    private List<String> allowedResults;
    private Integer winningPoints;
    private Integer lossPoints;

    public Integer getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public Integer getNumberOfMatchesPerPlayer() {
        return numberOfMatchesPerPlayer;
    }

    public void setNumberOfMatchesPerPlayer(Integer numberOfMatchesPerPlayer) {
        this.numberOfMatchesPerPlayer = numberOfMatchesPerPlayer;
    }

    public List<String> getAllowedResults() {
        return allowedResults;
    }

    public void setAllowedResults(List<String> allowedResults) {
        this.allowedResults = allowedResults;
    }

    public Integer getWinningPoints() {
        return winningPoints;
    }

    public void setWinningPoints(Integer winningPoints) {
        this.winningPoints = winningPoints;
    }

    public Integer getLossPoints() {
        return lossPoints;
    }

    public void setLossPoints(Integer lossPoints) {
        this.lossPoints = lossPoints;
    }
}
