package com.mikosz.playerstats.controller;

import com.mikosz.playerstats.model.Player;
import com.mikosz.playerstats.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Operation(summary = "Get all players")
    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @Operation(summary = "Get player")
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    @Operation(summary = "Create new player")
    @PostMapping
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        Player created = playerService.createPlayer(player);
        return ResponseEntity.ok(created);
    }

    @Operation(summary = "Update new player")
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @Valid @RequestBody Player player) {
        Player updated = playerService.updatePlayer(id, player);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Delete new player")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }
}
