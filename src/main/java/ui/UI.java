package ui;

import data.Command;
import data.GameState;
import data.Player;

import java.util.Arrays;
import java.util.Scanner;

public class UI {

    public static Command promptCommand() {
        System.out.print("Kommando: ");
        var sc = new Scanner(System.in);
        var commandText = sc.nextLine();
        return new Command(commandText);
    }

    public static void drawEmptyField() {
        System.out.println("  | 0 | 1 | 2");
        System.out.println("A | - | - | -");
        System.out.println("B | - | - | -");
        System.out.println("C | - | - | -");
    }

    public static void drawGameState(GameDTO gameDTO) {
        var playerField = gameDTO.getField();
        var stringField = getStringField(playerField);

        System.out.println("  | 0 | 1 | 2");
        System.out.println(String.format("A | %s | %s | %s", stringField[0][0], stringField[0][1], stringField[0][2]));
        System.out.println(String.format("B | %s | %s | %s", stringField[1][0], stringField[1][1], stringField[1][2]));
        System.out.println(String.format("C | %s | %s | %s", stringField[2][0], stringField[2][1], stringField[2][2]));

        switch (gameDTO.getState()) {
            case WON_P1 -> {
                System.out.println("Player 1 wins");
            }
            case WON_P2 -> {
                System.out.println("Player 2 wins");
            }
            case DRAW -> {
                System.out.println("Draw");
            }
        }
    }

    private static String[][] getStringField(Player[][] playerField) {
        return Arrays.stream(playerField)
                .map(players -> Arrays.stream(players)
                        .map(UI::toMarker)
                        .toArray(String[]::new))
                .toArray(String[][]::new);
    }

    private static String toMarker(Player player) {
        if (player == null) return "-";
        switch (player) {
            case P1 -> {
                return "X";
            }
            case P2 -> {
                return "O";
            }
        }
        throw new IllegalArgumentException();
    }
}
