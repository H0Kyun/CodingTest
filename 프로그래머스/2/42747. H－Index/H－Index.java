import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int answer = 0;
        int h = Integer.MAX_VALUE;
        
        for(int i = citations.length - 1; i >= 0; i--) {
            if(citations[i] < h) {
                h = citations[i];
            }
            
            if(h < citations.length - i) break;
            
            answer++;
        }
        
        return answer;
    }
}