import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ28702 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String line = br.readLine();
            try {
                int num = Integer.parseInt(line);
                int nextNum = num + (3 - i);
                if (nextNum % 15 == 0) {
                    System.out.println("FizzBuzz");
                } else if (nextNum % 3 == 0) {
                    System.out.println("Fizz");
                } else if (nextNum % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(nextNum);
                }
                break;
            } catch (NumberFormatException e) {
                continue;
            }
        }
    }
}
