package logic;

import data.Coord;

public class CoordMapper {

    public static final Coord INVALID_COORD = new Coord(-1, -1);

    public static Coord map(String text) {
        if (text.length() != 2){
            return INVALID_COORD;
        }

        var row = text.charAt(0);
        var col = text.charAt(1);

        if (Character.isAlphabetic(row) && Character.isDigit(col)) {
            var rowIdx = Character.toTitleCase(row) - 'A';
            var colIdx = col - '0';
            return new Coord(rowIdx, colIdx);
        } else {
            return INVALID_COORD;
        }
    }

}
