package com.infobip.TournamentAPI.bootstrap;

import com.infobip.TournamentAPI.domain.Player;
import com.infobip.TournamentAPI.repositories.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final PlayerRepository playerRepository;

    public Bootstrap(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void run(String... args) {

        savePlayers();
    }

    private void savePlayers() {

        Player player1 = new Player();
        player1.setName("Noriko Hidaka");
        player1.setAge(57);

        playerRepository.save(player1);

        Player player2 = new Player();
        player2.setName("Chika Sakamoto");
        player2.setAge(60);

        playerRepository.save(player2);

        Player player3 = new Player();
        player3.setName("Shigesato Itoi");
        player3.setAge(71);

        playerRepository.save(player3);

        Player player4 = new Player();
        player4.setName("Sumi Shimamoto");
        player4.setAge(65);

        playerRepository.save(player4);

        Player player5 = new Player();
        player5.setName("Machiko Washio");
        player5.setAge(70);

        playerRepository.save(player5);

        Player player6 = new Player();
        player6.setName("Reiko Suzuki");
        player6.setAge(75);

        playerRepository.save(player6);
    }
}
