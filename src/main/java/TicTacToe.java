import data.Command;
import data.Coord;
import logic.CoordMapper;
import logic.Game;
import logic.GameMapper;
import ui.UI;

public class TicTacToe {

    public static void main(String[] args) {
        UI.drawEmptyField();
        new TicTacToe().playGame();
    }

    private Game game;

    public void playGame() {
        this.game = new Game();
        while (true) playRound(game);
    }

    private void playRound(Game game) {
        var command = UI.promptCommand();
        runCommand(command);

        var gameDTO = GameMapper.map(this.game);
        UI.drawGameState(gameDTO);
    }

    void runCommand(Command command) {
        if (command.isNew()) game.resetGame();
        else if (command.isEnd()) exit();
        else {
            var coord = CoordMapper.map(command.getText());
            makeTurn(coord);
        }
    }

    void makeTurn(Coord coord) {
        if (game.turnValid(coord)) {
            game.makeTurn(coord);
            game.switchPlayer();
        }
    }

    private void exit() {
        System.exit(0);
    }

}
