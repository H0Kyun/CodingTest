import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int stringLength = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long answer = 0;
        long pow = 1;
        long mod = 1234567891;
        
        for (int i = 0; i < stringLength; ++i) {
            long number = ((((str.charAt(i) - 'a') + 1) % 1234567891) *  pow) % mod;
            pow = (pow * 31) % 1234567891;
            
            answer += number;
        }
        answer %= mod;
        
        System.out.println(answer);
    }
}