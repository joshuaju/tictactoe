package logic;

import ui.GameDTO;

public class GameMapper {

    public static GameDTO map(Game game) {
        return new GameDTO(game.getField(), game.getState());
    }


}
