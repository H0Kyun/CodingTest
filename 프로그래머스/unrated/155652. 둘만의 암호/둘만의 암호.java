import java.util.Arrays;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        
        for(int i = 0; i < s.length(); i++) {
            int idx = 0;
            char temp = s.charAt(i);
            /* 1증가 하고 검사하고 반복
               while문을 생각하지 못 해 코드가 참 이상했다 */
            while(idx < index) {
                temp++;
                if(temp > 'z') temp = 'a';
                
                // skip도 문자 배열로 만들어 루프 돌렸는데 그럴필요없었다.
                if(!skip.contains(Character.toString(temp)))
                    idx++;
            }
            
            answer += Character.toString(temp);
        }
        
        return answer;
    }
}