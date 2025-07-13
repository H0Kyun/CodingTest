import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        
        int answer = 0;
        
        while(st.hasMoreTokens()) {
            int number = Integer.parseInt(st.nextToken());
            
            answer += number * number;
        }
        
        System.out.println(answer % 10);
    }
}