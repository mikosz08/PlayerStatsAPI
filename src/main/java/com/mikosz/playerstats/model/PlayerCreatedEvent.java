package com.mikosz.playerstats.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerCreatedEvent {
    private Long id;
    private String username;
    private int level;
}
