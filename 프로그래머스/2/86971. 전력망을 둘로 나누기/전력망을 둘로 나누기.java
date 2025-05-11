import java.util.ArrayList;

class Solution {
    ArrayList<Integer> [] graph;
    int answer;
    
    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        // 그래프 제작
        graph = new ArrayList [n + 1];
        
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int[] i : wires) {
            int p = i[0];
            int c = i[1];
            graph[p].add(c);
            graph[c].add(p);
        }
        
        // 1 번부터 자식 노드 탐색 시작
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        
        int count = dfs(1, visited, n);
        
        return answer;
    }

    int dfs(int visitedTransmissionTowerId, boolean[] visited, int transmissionTowerTotalCount){
        int connectedTransmissionTowerCount = 1;

        for(int transmissionTowerId : graph[visitedTransmissionTowerId]) {
            if(visited[transmissionTowerId]) {
                continue;
            }
            
            visited[transmissionTowerId] = true;
            
            // 연결된 송전탑이 있으면 그 송전탑과 연결된 다른 송전탑의 합을 더해준다.
            connectedTransmissionTowerCount += dfs(transmissionTowerId, visited, transmissionTowerTotalCount);
        }
        
        // 모든 연결된 송전탑 수에 전체 송전탑 수를 빼면 해당 송전탑과 연결을 잘랐을 때 발생하는 차이알 수 있다.
        // 이 값과 전역 변수 answer 중 최소값을 구하면 답을 찾을 수 있다.
        int isolatedTransmissionTowerCount = transmissionTowerTotalCount - connectedTransmissionTowerCount;
        answer = Math.min(answer, (Math.abs(connectedTransmissionTowerCount - isolatedTransmissionTowerCount)));
        
        return connectedTransmissionTowerCount;
    }
}