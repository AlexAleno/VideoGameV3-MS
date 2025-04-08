package com.champsoft.gamemanagement.DataAccess;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameId {
    @Column(name = "game_id") // Map uuid to game_id column
    private String uuid;
}
