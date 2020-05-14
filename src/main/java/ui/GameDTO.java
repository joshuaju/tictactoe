package ui;

import data.GameState;
import data.Player;

public class GameDTO {

    private final Player[][] field;
    private final GameState state;

    public GameDTO(Player[][] field, GameState state) {
        this.field = field;
        this.state = state;
    }

    public Player[][] getField() {
        return field;
    }

    public GameState getState() {
        return state;
    }
}
