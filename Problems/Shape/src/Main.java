import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String output = "You have chosen a ";
        switch (input) {
            case "1":
                output += "square";
                break;
            case "2":
                output += "circle";
                break;
            case "3":
                output += "triangle";
                break;
            case "4":
                output += "rhombus";
                break;
            default:
                output = "There is no such shape!";
                break;
        }
        System.out.println(output);
    }
}