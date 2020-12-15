package battleship.board;

public class Board {

    private final char[][] shipView = initializeBoard();
    private final char[][] fogView = initializeBoard();

    protected final char[][] initializeBoard() {
        char[][] cells = new char[10][];
        for (int i = 0; i < 10; i++) {
            cells[i] = new char[]{'~', '~', '~', '~', '~', '~', '~', '~', '~', '~'};
        }
        return cells;
    }

    public char getCellContent(Coordinates coordinates) {
        return shipView[coordinates.getRow()][coordinates.getColumn()];
    }

    public void updateBoard(Coordinates from, Coordinates to, char actionSymbol) {
        for (int i = from.getRow(); i < to.getRow() + 1; i++) {
            for (int j = from.getColumn(); j < to.getColumn() + 1; j++) {
                shipView[i][j] = actionSymbol;
            }
        }
    }

    public void updateBoard(Coordinates usersShot, char actionSymbol) {
        shipView[usersShot.getRow()][usersShot.getColumn()] = actionSymbol;
        fogView[usersShot.getRow()][usersShot.getColumn()] = actionSymbol;
    }

    public char[][] getShipView() {
        return shipView;
    }

    public char[][] getFogView() {
        return fogView;
    }
}
