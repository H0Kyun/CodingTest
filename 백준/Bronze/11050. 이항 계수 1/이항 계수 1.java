import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int nFactorial = 1;
        for (int i = n; i >= 1; --i) {
            nFactorial *= i;
        }
        
        int kFactorial = 1;
        for (int i = k; i >= 1; --i) {
            kFactorial *= i;
        }
        
        int nMinusKFactorial = 1;
        for (int i = n - k; i >= 1; --i) {
            nMinusKFactorial *= i;
        }
        
        System.out.println((nFactorial / (kFactorial * nMinusKFactorial)));
    }
}