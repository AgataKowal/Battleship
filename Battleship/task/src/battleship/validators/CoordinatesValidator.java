package battleship.validators;

import battleship.board.Coordinates;

public class CoordinatesValidator {

    public boolean areCoordinatesInRange(Coordinates... coordinates) {
        boolean areValid = true;
        for (Coordinates c : coordinates) {
            if (c.getColumn() < 0 || c.getColumn() > 9 || c.getRow() < 0 || c.getRow() > 9) {
                areValid = false;
                break;
            }
        }
        return areValid;
    }
}
