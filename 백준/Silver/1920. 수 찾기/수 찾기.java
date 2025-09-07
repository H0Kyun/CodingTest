import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Set<Integer> set = new HashSet<Integer>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        while(st.hasMoreTokens()) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        
        int m = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine(), " ");
        
        while(st.hasMoreTokens()) {
            System.out.println((set.contains(Integer.parseInt(st.nextToken())) ? '1' : '0'));
        }
        
    }
}