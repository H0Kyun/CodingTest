import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList();
        
        int index = -1;
        int numberOfProject = 0;
        int previousCountdown = 0;
        
        int[] deploymentCountdowns = new int[progresses.length];
        
        
        for (int i = 0; i < progresses.length; ++i) {
            int remainProgress = 100 - progresses[i];
            int deployCountdown = remainProgress / speeds[i];
            
            if (remainProgress % speeds[i] > 0) {
                deployCountdown++;
            }
            
            // deploymentCountdowns[i] = deployCountdown;
            
            if (deployCountdown > previousCountdown) {
                ++index;
                numberOfProject = 0;
                previousCountdown = deployCountdown;
            }
            
            if (index < answer.size()) {
                answer.set(index, ++numberOfProject);
            } else {
                answer.add(++numberOfProject);
            }
        }
        
//         for (int countdown : deploymentCountdowns) {
            
//             if (countdown > previousCountdown) {
//                 ++index;
//                 numberOfProject = 0;
//                 previousCountdown = countdown;
//             }
            
//             if (index < answer.size()) {
//                 answer.set(index, ++numberOfProject);
//             } else {
//                 answer.add(++numberOfProject);
//             }
            
//         }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}