import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int answer = 0;
        int index = people.length - 1;
        
        for (int i = 0; i <= index; ++i) {
            if (people[i] + people[index] > limit) {
                --i;
            }
            
            --index;

            ++answer;
        }
        
        return answer;
    }
}