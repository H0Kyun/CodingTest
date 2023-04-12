import java.util.PriorityQueue;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = numbers.length - 1; i >= 0; i--) {
            while(!pq.isEmpty()) {
                
                // 최소 힙에 있는 루트 값이 현재 숫자보다 크면
                // 루트 값을 답으로 넣고 힙에 현재 숫자를 추가한다.
                if(pq.peek() > numbers[i]) {
                    answer[i] = pq.peek();
                    pq.add(numbers[i]);
                    break;
                } else {
                    // 그게 아니면 최소힙의 루트를 제거한다.
                    pq.remove();
                }
            }
            
            // 최소힙이 비어있으면 나보다 큰 수가 없다는 뜻이므로
            // -1을 답으로 넣고 힙에 나를 추가한다.
            if(pq.isEmpty()) {
                answer[i] = -1;
                pq.add(numbers[i]);
                continue;
            }
        }
        
        return answer;
    }
}