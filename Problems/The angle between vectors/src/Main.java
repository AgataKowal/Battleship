import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int u1 = scanner.nextInt();
        int u2 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int v2 = scanner.nextInt();
        int dotProduct = u1 * v1 + u2 * v2;
        double uLength = Math.sqrt(u1 * u1 + u2 * u2);
        double vLength = Math.sqrt(v1 * v1 + v2 * v2);
        System.out.println(Math.acos(dotProduct / (uLength * vLength)) * 180 / Math.PI);
    }
}