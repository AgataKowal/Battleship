package battleship.validators;

import battleship.board.Coordinates;
import battleship.ships.Ship;

public class LengthValidator {

    public boolean isLengthValid(Coordinates from, Coordinates to, Ship ship) {
        return ship.getLength() == Coordinates.calculateDistance(from, to);
    }
}
