import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList());
        }
        
        for (int[] edgeInfo : edge) {
            graph.get(edgeInfo[0] - 1).add(edgeInfo[1] - 1);
            graph.get(edgeInfo[1] - 1).add(edgeInfo[0] - 1);
        }
        
        return this.bfs(n, graph);
    }
    
    private int bfs(int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];
        visited[0] = true;
        
        Queue<Integer> queue = new ArrayDeque();
        queue.offer(0);
        
        int answer = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(--size >= 0) {
                int index = queue.poll();
                
                for (int node : graph.get(index)) {
                    if (!visited[node]) {
                        queue.offer(node);
                        visited[node] = true;
                    }
                }
            }
            
            if (queue.size() != 0) {
                answer = queue.size();
            }
        }
        
        return answer;
    }
}