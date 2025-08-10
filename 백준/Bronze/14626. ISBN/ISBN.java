import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String isbnCode = br.readLine();

        int sumWithoutMissing = 0;
        int expectedCheckDigit = Character.getNumericValue(isbnCode.charAt(isbnCode.length() - 1));
        int missingWeight = 1;

        for (int idx = 0; idx < isbnCode.length() - 1; ++idx) {
            int weight = (idx % 2 == 0) ? 1 : 3;
            
            if (isbnCode.charAt(idx) != '*') {
                sumWithoutMissing += Character.getNumericValue(isbnCode.charAt(idx)) * weight;
            } else {
                missingWeight = weight;
            }
        }

        for (int digit = 0; digit <= 9; ++digit) {
            int calculatedCheckDigit = 10 - ((sumWithoutMissing + (digit * missingWeight)) % 10);

            if (calculatedCheckDigit % 10 == expectedCheckDigit) {
                System.out.println(digit);
                return;
            }
        }
    }
}