package battleship.ships;

import battleship.board.Coordinates;

public class Cruiser implements Ship {

    private static final String TYPE = "Cruiser";
    private static final int LENGTH = 3;
    private boolean isSuccessfullyPlaced = false;
    private final Coordinates[] coordinates = new Coordinates[LENGTH];


    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public int getLength() {
        return LENGTH;
    }

    @Override
    public Coordinates[] getCoordinates() {
        return coordinates;
    }

    @Override
    public boolean isSuccessfullyPlaced() {
        return isSuccessfullyPlaced;
    }

    @Override
    public void setCoordinates(Coordinates from, Coordinates to) {
        if (from.getRow() == to.getRow()) {
            for (int i = 0; i < coordinates.length; i++) {
                coordinates[i] = new Coordinates(from.getRow(), from.getColumn() + i);
            }
        } else {
            int constantColumn = from.getColumn();
            int rowBase = from.getRow();
            for (int i = 0; i < coordinates.length; i++) {
                coordinates[i] = new Coordinates(rowBase + i, constantColumn);
            }
        }
    }

    @Override
    public void setIsSuccessfullyPlaced(boolean isSuccessfullyPlaced) {
        this.isSuccessfullyPlaced = isSuccessfullyPlaced;
    }

    @Override
    public String toString() {
        return "Type: " + this.getType() + " length: " + this.getLength();
    }

}