package battleship.game;

import battleship.board.Board;
import battleship.board.BoardPrinter;
import battleship.board.Coordinates;
import battleship.board.CoordinatesMapper;
import battleship.ships.*;
import battleship.validators.AnotherObjectValidator;
import battleship.validators.CoordinatesValidator;
import battleship.validators.LengthValidator;
import battleship.validators.ObliqueCoordinatesValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final Board[] boards = {new Board(), new Board()};
    private final BoardPrinter printer = new BoardPrinter();
    private final CoordinatesMapper coordinatesMapper = new CoordinatesMapper();
    private final CoordinatesValidator coordinatesValidator = new CoordinatesValidator();
    private final Ship[][] ships = {
            {new AircraftCarrier(), new Battleship(), new Submarine(), new Cruiser(), new Destroyer()},
            {new AircraftCarrier(), new Battleship(), new Submarine(), new Cruiser(), new Destroyer()}};
    private final int[] shipCells = {17, 17};

    public void placeShips() {

        Scanner scanner = new Scanner(System.in);

        ObliqueCoordinatesValidator obliqueCoordinatesValidator = new ObliqueCoordinatesValidator();
        LengthValidator lengthValidator = new LengthValidator();
        AnotherObjectValidator anotherObjectValidator = new AnotherObjectValidator();

        for (int i = 0; i < 2; i++) {
            System.out.printf("Player %d, place your ships on the game field%n", i + 1);
            printer.printShipView(boards[i]);
            for (Ship ship : ships[i]) {
                System.out.printf("Enter the coordinates of the %s (%d cells):%n", ship.getType(), ship.getLength());
                while (!ship.isSuccessfullyPlaced()) {
                    String[] userInput = scanner.nextLine().trim().split("\\s");
                    Coordinates from = coordinatesMapper.mapCoordinates(userInput[0]);
                    Coordinates to = coordinatesMapper.mapCoordinates(userInput[1]);
                    if (coordinatesNeedToBeSwapped(from, to)) {
                        Coordinates temp = from;
                        from = to;
                        to = temp;
                    }
                    if (!coordinatesValidator.areCoordinatesInRange(from, to) ||
                            obliqueCoordinatesValidator.areCoordinatesOblique(from, to)) {
                        System.out.println("Error! Wrong ship location! Try again:");
                    } else if (!lengthValidator.isLengthValid(from, to, ship)) {
                        System.out.println("Error! Wrong length of the " + ship.getType() + "! Try again:");
                    } else if (!anotherObjectValidator.isNotToCloseToAnotherShip(from, to, boards[i])) {
                        System.out.println("Error! You placed it too close to another one. Try again:");
                    } else {
                        boards[i].updateBoard(from, to, 'O');
                        ship.setCoordinates(from, to);
                        ship.setIsSuccessfullyPlaced(true);
                        printer.printShipView(boards[i]);
                    }
                }
            }
            System.out.println("Press Enter and pass the move to another player");
            scanner.nextLine();
        }

    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        int playerNumber = 1;

        while (shipCells[0] != 0 || shipCells[1] != 0) {
            printer.printPlayerPerspective(boards, playerNumber);
            System.out.printf("Player %d, it's your turn:%n", playerNumber);
            String input = scanner.nextLine().trim();
            Coordinates coordinates = coordinatesMapper.mapCoordinates(input);
            if (!coordinatesValidator.areCoordinatesInRange(coordinates)) {
                System.out.println("Error! You entered the wrong coordinates!");
            } else {
                int boardIndex = playerNumber == 1 ? 1 : 0;
                char cellContent = boards[boardIndex].getCellContent(coordinates);
                if ('O' == cellContent) {
                    boards[boardIndex].updateBoard(coordinates, 'X');
                    shipCells[playerNumber - 1] -= 1;
                    verifyShipsStatus(coordinates, playerNumber);
                } else if ('X' == cellContent) {
                    boards[boardIndex].updateBoard(coordinates, 'X');
                    verifyShipsStatus(coordinates, playerNumber);
                } else {
                    boards[boardIndex].updateBoard(coordinates, 'M');
                    System.out.println("You missed!");
                }
                playerNumber = playerNumber == 1 ? 2 : 1;
                System.out.println("Press Enter and pass the move to another player");
                scanner.nextLine();
            }
        }
    }

    private void verifyShipsStatus(Coordinates coordinates, int playerNumber) {
        if (shipCells[playerNumber - 1] == 0) {
            System.out.println("You sank the last ship. You won. Congratulations!");
        } else if (shipIsSank(coordinates, playerNumber)) {
            System.out.println("You sank a ship!");
        } else {
            System.out.println("You hit a ship!");
        }
    }

    private boolean shipIsSank(Coordinates coordinates, int playerNumber) {
        boolean isSank = true;
        int index = playerNumber == 1 ? 1 : 0;
        for (Ship ship : ships[index]) {
            List<Coordinates> list = Arrays.asList(ship.getCoordinates());
            if (list.contains(coordinates)) {
                for (Coordinates c : list) {
                    if (boards[index].getCellContent(c) != 'X') {
                        isSank = false;
                        break;
                    }
                }
            }
        }
        return isSank;
    }

    private boolean coordinatesNeedToBeSwapped(Coordinates from, Coordinates to) {
        if (from.getRow() == to.getRow()) {
            return from.getColumn() > to.getColumn();
        } else {
            return from.getRow() > to.getRow();
        }
    }
}
