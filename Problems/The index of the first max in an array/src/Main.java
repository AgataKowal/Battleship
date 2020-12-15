import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        int[] array = Arrays.stream(scanner.nextLine().trim().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                index = i;
            }
        }
        System.out.println(index);
    }
}