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
            } else {
                sentence = sentence.replaceAll("\\.$", "");
            }
            
            StringTokenizer st = new StringTokenizer(sentence, " ");
            boolean isValid = true;
            
            while(st.hasMoreTokens() && isValid) {
                String token = st.nextToken();
                
                for (int i = 0; i < token.length(); ++i) {
                    char t= token.charAt(i);
                    if (t == '(') {
                        delimiters.addFirst(t);
                    } else if (t == '[') {
                        delimiters.addFirst(t);
                    } else if (t == ')') {
                        if (delimiters.isEmpty() || delimiters.peek() != '(') {
                            isValid = false;
                            break;
                        }
                        
                        delimiters.removeFirst();
                    } else if (t == ']') {
                        if (delimiters.isEmpty() || delimiters.peek() != '[') {
                            isValid = false;
                            break;
                        }
                        
                        delimiters.removeFirst();
                    }
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