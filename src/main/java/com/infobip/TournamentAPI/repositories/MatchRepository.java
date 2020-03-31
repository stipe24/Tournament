package com.infobip.TournamentAPI.repositories;

import com.infobip.TournamentAPI.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Integer> {
}
