import java.util.Arrays;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        // 1증가 하고 검사하고 1증가하고 검사하고?
        for(int i = 0; i < s.length(); i++) {
            int count = index;
            for(int j = 1; j <= count; j++) {
                char current = (char)(s.charAt(i) + j);
                if( current > 'z')
                    current -= 26;
                if( current > 'z')
                    current -= 26;
                
                for(int k = 0; k < skip.length(); k++) {
                    if(current == skip.charAt(k)) count++;
                }
            }
            char temp = (char)(s.charAt(i) + count);
            System.out.println(count);
            if(temp > 'z') 
                temp -= 26;
            if( temp > 'z')
                    temp -= 26;
            answer += Character.toString(temp);
        }
        
        return answer;
    }
}