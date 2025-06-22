import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long answer = 0;
        long left = times[0];
        long right = (long) times[times.length - 1] * n;
        
        while(left <= right) {
            long mid = (right + left) / 2L;
            
            long people = 0L;
            
            for (int time : times) {
                people += mid / time;
                
                if (people >= n) {
                    break;
                }
            }
            
            if (people >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
}