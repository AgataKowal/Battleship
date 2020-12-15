import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        int sum = 0;
        int amount = 0;
        for (int i = from; i < to + 1; i++) {
            if (i % 3 == 0) {
                sum += i;
                amount += 1;
            }
        }
        System.out.println(sum * 1.0 / amount);
    }
}