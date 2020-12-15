package battleship.validators;

import battleship.board.Board;
import battleship.board.Coordinates;

public class AnotherObjectValidator {

    public boolean isNotToCloseToAnotherShip(Coordinates from, Coordinates to, Board board) {
        int startRow = from.getRow() == 0 ? 1 : from.getRow();
        int endRow = to.getRow() == 9 ? 8 : to.getRow();
        int startColumn = from.getColumn() == 0 ? 1 : from.getColumn();
        int endColumn = to.getColumn() == 9 ? 8 : to.getColumn();
        for (int i = startRow - 1; i < endRow + 2; i++) {
            for (int j = startColumn - 1; j < endColumn + 2; j++) {
                if (board.getCellContent(new Coordinates(i, j)) == 'O') {
                    return false;
                }
            }
        }
        return true;
    }
}
