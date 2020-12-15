import java.util.ArrayDeque;
import java.util.Scanner;

class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amountOfCommands = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> toPrint = new ArrayDeque<>();
        ArrayDeque<Integer> maxes = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < amountOfCommands; i++) {
            String currentInput = scanner.nextLine().trim();
            if ("pop".equals(currentInput)) {
                maxes.pop();
            } else if ("max".equals(currentInput)) {
                toPrint.push(maxes.peek());
            } else if (currentInput.startsWith("push")) {
                int number = Integer.parseInt(currentInput.substring(5));
                max = Math.max(number, max);
                maxes.push(max);
            } else {
                System.out.println("Invalid command!");
            }
        }
        while (!toPrint.isEmpty()) {
            System.out.println(toPrint.pollLast());
        }
    }
}