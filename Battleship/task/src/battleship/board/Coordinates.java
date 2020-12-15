package battleship.board;

public class Coordinates {

    private int row;
    private int column;

    public Coordinates(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public static int calculateDistance(Coordinates from, Coordinates to) {
        return from.getColumn() == to.getColumn() ? to.getRow() - from.getRow() + 1 : to.getColumn() - from.getColumn() + 1;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (row != that.row) return false;
        return column == that.column;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        return result;
    }
}
