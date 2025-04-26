import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<String>((str1, str2) -> {
            return (Integer.parseInt(str1.concat(str2)) - Integer.parseInt(str2.concat(str1))) * -1;
        });
        
        for (int number : numbers) {
            pq.offer(Integer.toString(number));
        }
        
        StringBuilder answer = new StringBuilder();
            
        while(!pq.isEmpty()) {
            answer.append(pq.poll());
        }
        
        if (answer.toString().charAt(0) == '0') {
            return "0";
        }

        return answer.toString();
    }
}