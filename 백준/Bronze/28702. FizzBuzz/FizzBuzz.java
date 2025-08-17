import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; ++i) {
            String str = br.readLine();

            try {
                int number = Integer.parseInt(str);
                if (i == 0) {
                    number += 3;
                } else if (i == 1) {
                    number += 2;
                } else {
                    number += 1;
                }

                if (number % 3 == 0 && number % 5 == 0) {
                    System.out.println("FizzBuzz");
                } else if (number % 3 == 0) {
                    System.out.println("Fizz");
                } else if (number % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(number);
                }

                return;
            } catch (NumberFormatException e) {
                continue;
            }
        }
    }
}