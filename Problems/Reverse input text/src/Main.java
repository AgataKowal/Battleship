import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] input = reader.readLine().toCharArray();
        for (int i = input.length - 1; i >= 0; i--) {
            System.out.print(input[i]);
        }
        reader.close();
    }
}