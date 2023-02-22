import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;

class Solution {
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        
        Set<Integer> set = new HashSet<>();
        
        while(!q.isEmpty()) {
            int size = q.size();
            while(--size >= 0) {
                x = q.poll();
                if(set.contains(x)) continue;
                set.add(x);
                
                if(x == y) return answer;
            
                if(x + n <= 1000000) {
                    q.offer(x + n);
                }
            
                if(x * 2 <= 1000000) {
                    q.offer(x * 2);
                }
            
                if(x * 3 <= 1000000) {
                    q.offer(x * 3);
                }  
            }
            answer++;
        }
        if(x != y) return -1;
        return answer;
    }
}
