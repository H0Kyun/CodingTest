import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ISBN = br.readLine();

        int checkNumber = 0;
        int m = Character.getNumericValue(ISBN.charAt(ISBN.length() - 1));

        int value = 1;

        for (int i = 0; i < ISBN.length() - 1; ++i) {
            int mul = i % 2 == 0 ? 1 : 3;
            
            if (ISBN.charAt(i) != '*') {
                checkNumber += Character.getNumericValue(ISBN.charAt(i)) * mul;
            } else {
                value = mul;
            }
        }

        for (int i = 0; i <= 9; ++i) {
            int result = 10 - ((checkNumber + (i * value)) % 10);

            if (result == m || (m == 0 && result == 10)) {
                System.out.println(i);
                return;
            }
        }
    }
}