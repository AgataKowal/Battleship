package battleship.board;

public class CoordinatesMapper {

    public Coordinates mapCoordinates(String userInput) {
        return new Coordinates(extractRowNumber(userInput), extractColumnNumber(userInput));
    }

    public int extractColumnNumber(String userInput) {
        return Integer.parseInt(userInput.substring(1)) - 1;
    }

    public int extractRowNumber(String userInput) {
        return userInput.charAt(0) - 65;
    }

}
