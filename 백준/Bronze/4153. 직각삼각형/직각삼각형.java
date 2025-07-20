import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            
            int hypotenuse = Math.max(a, Math.max(b, c));
            int base = 0;
            int height = 0;
            if (hypotenuse == c) {
                base = a;
                height = b;
            } else if (hypotenuse == b) {
                base = a;
                height = c;
            } else {
                base = b;
                height = c;
            }
            
            if (base * base + height * height == hypotenuse * hypotenuse) {
                System.out.println("right");
            } else {
                System.out.println("wrong");                
            }
        }
    }
}