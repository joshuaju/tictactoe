package logic;

import data.Command;
import data.Coord;
import data.GameState;
import data.Player;

import java.util.HashMap;
import java.util.Map;

public class Game {

    private Map<String, Player> field;

    private Player activePlayer;

    public Game() {
        this(new HashMap<>());
    }

    public Game(Map<String, Player> field) {
        this.field = field;
    }

    public void applyCommand(Command cmd) {
        // TODO
    }

    public void switchPlayer() {
        // TODO
    }

    public void addTurn(Coord coord) {
        // TODO
    }

    public void resetGame() {
        // TODO
    }

    public GameState determineState() {
        return GameState.OPEN; // TODO
    }
}
