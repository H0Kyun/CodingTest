import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        if (arr.length == 0) {
            return new int[0];
        } else if (arr.length == 1) {
            int[] answer = {arr[0]};
            return answer;
        }
        
        List<Integer> answer = new ArrayList();
        
        answer.add(arr[0]);
        int latestIndex = answer.size() - 1;
        
        for (int i = 1; i < arr.length; ++i) {
            if (answer.get(latestIndex) != arr[i]) {
                answer.add(arr[i]);
                ++latestIndex;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}