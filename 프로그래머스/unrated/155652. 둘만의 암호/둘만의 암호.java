import java.util.Arrays;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        // 1증가 하고 검사하고 1증가하고 검사하고?
        for(int i = 0; i < s.length(); i++) {
            int idx = 0;
            char temp = s.charAt(i);
            while(idx < index) {
                temp++;
                if(temp > 'z') temp = 'a';
                
                if(!skip.contains(Character.toString(temp)))
                    idx++;
            }
            
            answer += Character.toString(temp);
        }
        
        return answer;
    }
}