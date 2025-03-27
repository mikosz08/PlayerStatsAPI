package com.mikosz.playerstats.config;

import com.mikosz.playerstats.model.Player;
import com.mikosz.playerstats.repository.PlayerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataSeeder implements CommandLineRunner {

    private final PlayerRepository playerRepository;

    public DataSeeder(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public void run(String... args) {
        if (playerRepository.count() == 0) {
            List<Player> players = List.of(
                    new Player(null, "Geralt", 50, 100000),
                    new Player(null, "Yennefer", 45, 90000),
                    new Player(null, "Ciri", 40, 85000),
                    new Player(null, "Triss", 42, 87000),
                    new Player(null, "Zoltan", 35, 72000),
                    new Player(null, "Vesemir", 48, 98000),
                    new Player(null, "Dandelion", 20, 40000),
                    new Player(null, "Lambert", 38, 79000),
                    new Player(null, "Eskel", 37, 77000),
                    new Player(null, "Regis", 50, 100000),

                    new Player(null, "Johnny Silverhand", 55, 120000),
                    new Player(null, "V (Male)", 45, 90000),
                    new Player(null, "V (Female)", 45, 90000),
                    new Player(null, "Judy Alvarez", 38, 80000),
                    new Player(null, "Panam Palmer", 39, 81000),
                    new Player(null, "River Ward", 36, 79000),
                    new Player(null, "Goro Takemura", 50, 95000),
                    new Player(null, "Adam Smasher", 60, 130000),
                    new Player(null, "Alt Cunningham", 49, 91000),
                    new Player(null, "Dexter DeShawn", 35, 75000)
            );

            playerRepository.saveAll(players);
            System.out.println("Seeded 20 characters into the database!");
        }
    }
}
