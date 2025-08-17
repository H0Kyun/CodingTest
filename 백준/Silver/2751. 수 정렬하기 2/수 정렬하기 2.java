import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean[] isNegative = new boolean[1000001];
        boolean[] isPositive = new boolean[1000001];

        for (int i = 0; i < n; ++i) {
            int number = Integer.parseInt(br.readLine());

            if (number < 0) {
                isNegative[-number] = true;
            } else {
                isPositive[number] = true;
            }
        }

        for (int i = isNegative.length - 1; i >= 0; --i) {
            if (isNegative[i]) {
                System.out.println(-i);
            }
        }

        for (int i = 0; i < isPositive.length; ++i) {
            if (isPositive[i]) {
                System.out.println(i);
            }
        }
    }
}