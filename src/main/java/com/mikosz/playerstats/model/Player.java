package com.mikosz.playerstats.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is mandatory")
    private String username;

    @Min(value = 1, message = "Level must be at least 1")
    private int level;

    @Min(value = 0, message = "Experience points must be 0 or more")
    private int experiencePoints;
}
