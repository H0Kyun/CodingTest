import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        int answer = 0;
        
        while(left <= right) {
            int mid = (left + right) / 2;
            
            int min = distance;
            int removeCount = rocks[0] - 0 < mid ? 1 : 0;
            int previousRock = rocks[0] - 0 < mid ? 0 : rocks[0];
            
            for (int i = 1; i < rocks.length; ++i) {
                if (mid > rocks[i] - previousRock) {
                    removeCount++;
                } else {
                    min = Math.min(min, rocks[i] - previousRock);
                    previousRock = rocks[i];
                }
            }
            
            removeCount += distance - previousRock < mid ? 1 : 0;
            
            if (removeCount <= n) {
                left = mid + 1;
                answer = Math.max(min, answer);
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}