import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stringLength = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long answer = 0;
        long pow = 1;
        long mod = 1234567891;

        // mod 분배 법칙
        // (a + b) mod m = ((a mod m) + (b mod m)) mod m (덧셈)
        // (a - b) mod m = ((a mod m) - (b mod m)) mod m (뺄셈)
        // (a * b) mod m = ((a mod m) * (b mod m)) mod m (곱셈) 
        /* 예제
         * (a * 1 + b * 1 * 31 + c * 1 * 31 * 31) % mod
         * = (a*1 %mode  b * 1 * 31% mod   c * 1 * 31 * 31% mod) % mod
         * = (a % mod * 1 %mod) %mod + (b % mod * 1 % mod * 31 % mod) % mod
         */
        for (int i = 0; i < stringLength; ++i) {
            long number = ((((str.charAt(i) - 'a') + 1) % 1234567891) *  pow) % mod;
            pow = (pow * 31) % mod;

            answer += number;
        }
        answer %= mod;

        System.out.println(answer);
    }
}
