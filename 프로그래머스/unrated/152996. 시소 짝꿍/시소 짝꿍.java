import java.util.Map;
import java.util.HashMap;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Map<Integer, Long> weightsMap = new HashMap<>();
        for(int i = 0; i < weights.length; i++) {
            if(weightsMap.get(weights[i]) == null) {
                weightsMap.put(weights[i], 1L);
            } else {
                answer += weightsMap.get(weights[i]);
                weightsMap.put(weights[i], weightsMap.get(weights[i]) + 1);
            }
             
            if(weights[i] % 2 == 0 && weightsMap.get(weights[i] / 2) != null)
                answer += weightsMap.get(weights[i] / 2);

            if(weightsMap.get(weights[i] * 2) != null)
                 answer += weightsMap.get(weights[i] * 2);
            
            if(weights[i] % 3 == 0 && weightsMap.get((weights[i] / 3) * 2) != null)
                answer += weightsMap.get((weights[i] / 3) * 2);
                
            if(weights[i] % 4 == 0 && weightsMap.get((weights[i] / 4) * 3) != null)
                answer += weightsMap.get((weights[i] / 4) * 3);
            
            
            if(weights[i] % 3 == 0 && weightsMap.get((weights[i] / 3) * 4) != null)
                answer += weightsMap.get((weights[i] / 3) * 4);
            
            if(weights[i] % 2 == 0 && weightsMap.get((weights[i] / 2) * 3) != null)
                answer += weightsMap.get((weights[i] / 2) * 3);
            
        }
        return answer;
    }
}