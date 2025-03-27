package com.mikosz.playerstats.service;

import com.mikosz.playerstats.model.Player;
import com.mikosz.playerstats.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerServiceTest {

    private PlayerRepository playerRepository;
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        playerRepository = mock(PlayerRepository.class);
        playerService = new PlayerService(playerRepository);
    }

    @Test
    void testGetAllPlayers_ReturnsAllPlayers() {
        Player p1 = new Player(1L, "Yarpen", 30, 44000);
        Player p2 = new Player(2L, "Zoltan", 40, 64000);
        Player p3 = new Player(3L, "Sheldon", 30, 44000);

        List<Player> players = List.of(p1, p2, p3);
        when(playerRepository.findAll()).thenReturn(players);

        List<Player> result = playerService.getAllPlayers();

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("Zoltan", result.get(1).getUsername());
        verify(playerRepository, times(1)).findAll();
    }

    @Test
    void testGetPlayerById_ReturnsPlayer() {
        Player player = new Player(1L, "Gerwant", 50, 1275000);
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player));

        Player result = playerService.getPlayerById(1L);

        assertNotNull(result);
        assertEquals("Gerwant", result.getUsername());
        verify(playerRepository, times(1)).findById(1L);
    }

    @Test
    void testGetPlayerById_ThrowsException_WhenNotFound() {
        when(playerRepository.findById(999L)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            playerService.getPlayerById(999L);
        });

        assertTrue(exception.getMessage().contains("Player not found"));
    }

    @Test
    void testCreatePlayer_SavesPlayer() {
        Player player = new Player(null, "Rache", 11, 10500);
        when(playerRepository.save(player)).thenReturn(player);

        Player created = playerService.createPlayer(player);

        assertEquals("Rache", created.getUsername());
        verify(playerRepository, times(1)).save(player);
    }

    @Test
    void testUpdatePlayer_UpdatesAndSavesPlayer() {
        Long id = 1L;
        Player existingPlayer = new Player(id, "Wakko", 1, 2600);
        Player updatedPlayer = new Player(id, "Wakako", 21, 26000);

        when(playerRepository.findById(id)).thenReturn(Optional.of(existingPlayer));
        when(playerRepository.save(existingPlayer)).thenReturn(existingPlayer);

        Player result = playerService.updatePlayer(id, updatedPlayer);

        assertEquals("Wakako", result.getUsername());
        assertEquals(21, result.getLevel());
        assertEquals(26000, result.getExperiencePoints());

        verify(playerRepository, times(1)).findById(id);
        verify(playerRepository, times(1)).save(existingPlayer);
    }

    @Test
    void testDeletePlayer_DeletesPlayer() {
        Long id = 1L;
        playerService.deletePlayer(id);
        verify(playerRepository, times(1)).deleteById(id);
    }

}
