import java.util.PriorityQueue;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = numbers.length - 1; i >= 0; i--) {
            
            while(!pq.isEmpty()) {
                if(pq.peek() > numbers[i]) {
                    answer[i] = pq.peek();
                    pq.add(numbers[i]);
                    break;
                } else {
                    pq.remove();
                }
            }
            
            if(pq.isEmpty()) {
                answer[i] = -1;
                pq.add(numbers[i]);
                continue;
            }
        }
        
        return answer;
    }
}