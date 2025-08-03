import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        
        int gcd = gcd(a, b);
        
        System.out.println(gcd);
        System.out.println(a * b / gcd);
    }
    
    public static int gcd(int a, int b) {
	    int c;
	    while (b != 0) {
		    c = a % b;
		    a = b;
		    b = c;
	    }
        
	    return a;
    }
}