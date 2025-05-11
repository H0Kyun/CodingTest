import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder(number);
    
        int start = 0;
        
        while(k > 0) {
            char maxNumber = '-'; // '0'이 문자열 안에 있으면 maxNumber가 갱신 안 되는 문제 해결
            int maxIndex = 0;
            
            // 시작 지점부터 K 까지 반복을 해서 가장 큰 수의 위치를 찾는다.
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
            // 앞자리가 가장 큰 수가 될 수 있게 수를 제거한다.
            answer.delete(start, maxIndex);
            
            // 시작 지점을 하나 민다.
            ++start;
            
            // 남은 수가 k 보다 작거나 같으면 시작 지점 이후 숫자를 모두 지운다.
            if (k >= answer.length() - start) {
                answer.delete(start, answer.length());
                break;
            }
        }
        
        return answer.toString();
    }
}