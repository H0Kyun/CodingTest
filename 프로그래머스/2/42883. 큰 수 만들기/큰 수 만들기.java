import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder(number);
        // K + 1까지 반복을 해서 가장 큰 수를 찾는다.
        // 앞자리가 가장 큰 수가 될 수 있게 수를 제거한다.
        // 위 과정을 반복해야 함!
        int start = 0;
        
        while(k > 0) {
            char maxNumber = '-';
            int maxIndex = 0;
            
            for (int i = start; i <= k + start; ++i) {
                if (answer.charAt(i) > maxNumber) {
                    maxNumber = answer.charAt(i);
                    maxIndex = i;
                }

                if (answer.charAt(i) == '9') {
                    maxIndex = i;
                    break;
                }
            }
            
           
            k -= maxIndex - start;
            answer.delete(start, maxIndex);
            
            ++start;
            
            if (k >= answer.length() - start) {
                answer.delete(start, answer.length());
                break;
            }
        }
        
        return answer.toString();
    }
}