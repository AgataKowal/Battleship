package battleship.validators;

import battleship.board.Coordinates;

public class ObliqueCoordinatesValidator {

    public boolean areCoordinatesOblique(Coordinates from, Coordinates to) {
        return from.getColumn() != to.getColumn() && from.getRow() != to.getRow();
    }
}
