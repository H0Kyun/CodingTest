import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < n; ++t) {
            Deque<Character> opendParenthesis = new ArrayDeque();
            
            String parenthesisString = br.readLine();
            boolean isVPS = true;
            
            for (int i = 0; i < parenthesisString.length(); ++i) {
                if (parenthesisString.charAt(i) == '(') {
                    opendParenthesis.addLast('(');
                } else if (opendParenthesis.pollLast() == null){
                    isVPS = false;
                    break;
                }
            }
            
            if (isVPS && opendParenthesis.isEmpty()) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
            
        }
        
        System.out.println(sb);
        
        br.close();
    }
}