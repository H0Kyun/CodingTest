import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int stringLength = Integer.parseInt(br.readLine());
        String str = br.readLine();
        long answer = 0;
        
        for (int i = 0; i < stringLength; ++i) {
            long number = (str.charAt(i) - 'a') + 1;
            
            answer += number * (long)Math.pow(31, i);
            answer %= 1234567891;
        }
        
        System.out.println(answer);
    }
}