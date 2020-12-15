import java.io.InputStream;

class Main {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        byte currentByte = (byte) inputStream.read();
        while (currentByte != -1) {
            System.out.print(currentByte);
            currentByte = (byte) inputStream.read();
        }
        inputStream.close();
    }
}