import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        char[][] array = new char[size][size];
        int center = size / 2;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j || i == center || j == center || j == size - 1 - i) {
                    array[i][j] = '*';
                } else {
                    array[i][j] = '.';
                }
            }
        }

        for (char[] chars : array) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }
}