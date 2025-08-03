import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String numberString = br.readLine();
        
        while(!numberString.equals("0")) {
            int num = Integer.parseInt(numberString);
            
            boolean isPalindrome = true;
            
            for (int i = 0; i < numberString.length() / 2; ++i) {
                if (numberString.charAt(i) != numberString.charAt(numberString.length() - 1 - i)) {
                    isPalindrome = false;
                    break;
                }
            }
            
            if (isPalindrome) {
                sb.append("yes\n");
            } else {
                sb.append("no\n");
            }
            
            numberString = br.readLine();
        }
        
        System.out.println(sb.toString());
    }
}