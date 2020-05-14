package logic;

import data.Coord;
import data.GameState;
import data.Player;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;

public class Game {
    private Player[][] field;

    private GameState state;
    private Player activePlayer;

    public Game() {
        resetGame();
    }

    private void setState(GameState state) {
        this.state = state;
    }

    public GameState getState() {
        return state;
    }

    public Player[][] getField() {
        return field;
    }

    public Player getActivePlayer() {
        return activePlayer;
    }

    public void switchPlayer() {
        this.activePlayer = activePlayer.next();
    }

    public void makeTurn(Coord coord) {
        if (GameState.OPEN == getState()) {
            field[coord.getRow()][coord.getCol()] = activePlayer;
            var newState = determineState();
            setState(newState);
        }
    }

    private GameState determineState() {
        return checkColumns()
                .or(this::checkRows)
                .or(this::checkDiagonals)
                .map(this::mapPlayer)
                .orElseGet(this::isOpenOrDraw);
    }

    private GameState isOpenOrDraw() {
        for (var row : field) {
            for (var cell : row) {
                if (cell != null) return GameState.OPEN;
            }
        }
        return GameState.DRAW;
    }

    private GameState mapPlayer(Player player) {
        switch (player) {
            case P1 -> {
                return GameState.WON_P1;
            }
            case P2 -> {
                return GameState.WON_P2;
            }
            default -> throw new IllegalArgumentException();
        }
    }

    private Optional<Player> checkColumns() {
        return IntStream.rangeClosed(0, 2)
                .mapToObj(col -> {
                    var first = field[0][col];
                    var second = field[1][col];
                    var third = field[2][col];

                    boolean allTheSame = first == second && first == third;
                    if (allTheSame) return first;
                    else return null;
                })
                .filter(Objects::nonNull)
                .findFirst();
    }

    private Optional<Player> checkRows() {
        return IntStream.rangeClosed(0, 2)
                .mapToObj(row -> {
                    var first = field[row][0];
                    var second = field[row][1];
                    var third = field[row][2];

                    boolean allTheSame = first == second && first == third;
                    if (allTheSame) return first;
                    else return null;
                })
                .filter(Objects::nonNull)
                .findFirst();
    }

    private Optional<Player> checkDiagonals() {
        // chekc ascending diagonal
        var firstAsc = field[0][0];
        var secondAsc = field[1][1];
        var thirdAsc = field[2][2];
        boolean allTheSameAsc = firstAsc == secondAsc && firstAsc == thirdAsc;
        if (allTheSameAsc)
            return Optional.ofNullable(firstAsc);

        // check descending diagonal
        var firstDesc = field[2][0];
        var secondDesc = field[1][1];
        var thirdDesc = field[0][2];
        boolean allTheSameDesc = firstDesc == secondDesc && firstDesc == thirdDesc;
        if (allTheSameDesc)
            return Optional.ofNullable(firstDesc);

        return Optional.empty();
    }

    public boolean turnValid(Coord coord) {
        try {
            return field[coord.getRow()][coord.getCol()] == null;
        } catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    public void resetGame() {
        this.state = GameState.OPEN;
        this.field = new Player[3][3];
        this.activePlayer = Player.P1;
    }

}
