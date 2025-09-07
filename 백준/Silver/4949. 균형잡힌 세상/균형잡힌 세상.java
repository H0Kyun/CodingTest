import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Main {
    public static void main (String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            Deque<Character> delimiters = new ArrayDeque<Character>();
            String sentence = br.readLine();
            
            if (sentence.equals(".")) {
                System.out.println(sb);
                return;
            }
            
            boolean isValid = true;
                
            for (int i = 0; i < sentence.length(); ++i) {
                char character = sentence.charAt(i);
                
                if (character == '(' || character == '[') {
                    delimiters.addFirst(character);
                } else if (character == ')' || character == ']') {
                    char opening = character == ')' ? '(' : '[';

                    if (delimiters.isEmpty() || delimiters.peek() != opening) {
                        isValid = false;
                        break;
                    }

                    delimiters.removeFirst();
                }
            }
            
            if (isValid && delimiters.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
    }
}