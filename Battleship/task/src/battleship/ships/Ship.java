package battleship.ships;

import battleship.board.Coordinates;

public interface Ship {

    String getType();

    int getLength();

    Coordinates[] getCoordinates();

    boolean isSuccessfullyPlaced();

    void setCoordinates(Coordinates from, Coordinates to);

    void setIsSuccessfullyPlaced(boolean isSuccessfullyPlaced);
}
