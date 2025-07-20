import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] sides = new int[3];
            boolean isBreak = true;
            
            for (int i = 0; i < 3; ++i) {
                sides[i] = Integer.parseInt(st.nextToken());
                
                if (sides[i] != 0) {
                    isBreak = false;
                }
            }
            
            if (isBreak) {
                break;
            }
            
            Arrays.sort(sides);
            
            if (sides[0] * sides[0] + sides[1] * sides[1] == sides[2] * sides[2]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");                
            }
        }
    }
}