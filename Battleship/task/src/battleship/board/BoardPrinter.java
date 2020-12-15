package battleship.board;

public class BoardPrinter {

    private final Board board = new Board();

    public void printShipView(Board board) {
        printBoard(board.getShipView());
    }

    public void printFogView(Board board) {
        printBoard(board.getFogView());
    }

    public void printPlayerPerspective(Board[] boards, int playerNumber) {
        printBoard(board.getFogView());
        System.out.println("---------------------");
        printBoard(boards[playerNumber - 1].getShipView());
    }

    private void printBoard(char[][] cells) {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        for (int i = 0; i < cells.length; i++) {
            System.out.print((char) (65 + i));
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(" " + cells[i][j]);
            }
            System.out.print("\n");
        }
    }
}
