package com.mikosz.playerstats.service;

import com.mikosz.playerstats.model.Player;
import com.mikosz.playerstats.model.PlayerCreatedEvent;
import com.mikosz.playerstats.rabbitmq.publisher.PlayerEventPublisher;
import com.mikosz.playerstats.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final PlayerEventPublisher eventPublisher;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, PlayerEventPublisher eventPublisher) {
        this.playerRepository = playerRepository;
        this.eventPublisher = eventPublisher;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + id));
    }

    public Player createPlayer(Player player) {
        Player created = playerRepository.save(player);

        PlayerCreatedEvent event = new PlayerCreatedEvent(
                created.getId(),
                created.getUsername(),
                created.getLevel());

        eventPublisher.publish(event);
        return created;
    }

    public Player updatePlayer(Long id, Player updatedPlayer) {
        Player existingPlayer = getPlayerById(id);
        existingPlayer.setUsername(updatedPlayer.getUsername());
        existingPlayer.setLevel(updatedPlayer.getLevel());
        existingPlayer.setExperiencePoints(updatedPlayer.getExperiencePoints());
        return playerRepository.save(existingPlayer);
    }

    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
