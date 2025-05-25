import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int answer = 0;
        int index = people.length - 1;
        
        for (int i = 0; i < people.length; ++i) {  
            if (people[i] == 0) {
                continue;
            }
            
            if (people[index] == 0) {
                break;
            }
                
            int sum = people[i] + people[index];

            if (sum <= limit) {
                people[i] = 0;
                people[index] = 0;
                --index;
            } else {
                people[index] = 0;
                --index;
                --i;
            }
            
            ++answer;
        }
        
        return answer;
    }
}