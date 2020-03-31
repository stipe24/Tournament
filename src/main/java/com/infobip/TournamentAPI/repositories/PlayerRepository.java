package com.infobip.TournamentAPI.repositories;

import com.infobip.TournamentAPI.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
