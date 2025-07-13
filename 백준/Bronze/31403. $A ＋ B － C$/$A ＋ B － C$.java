import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer a = Integer.parseInt(br.readLine());
        Integer b = Integer.parseInt(br.readLine());
        Integer c = Integer.parseInt(br.readLine());
        
        System.out.println(a + b - c);
        System.out.println(Integer.parseInt(a.toString() + b.toString()) - c);
    }
}