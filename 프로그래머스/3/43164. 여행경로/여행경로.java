import java.util.*;

class Solution {
    public String[] solution(String[][] tickets) {
        // 공항명, 연결된 노드 저장 Map<String, LinkedList<String>>
        Map<String, List<String>> graph = new HashMap();
        
        for (String[] ticket : tickets) {
            if (!graph.containsKey(ticket[0])) {
                List<String> list = new LinkedList();
                list.add(ticket[1]);
                
                graph.put(ticket[0], list);
            } else {
                List<String> list = graph.get(ticket[0]);
                list.add(ticket[1]);
                
                // 저장 후 각 List는 이름순 정렬을 해야 함
                Collections.sort(list);
            }
        }
        
        // 처음은 ICN 과 연결된 노드 탐색 탐색
        List<String> routes = dfs("ICN", graph, new ArrayList<String>());
        
        return routes.toArray(new String[routes.size()]);
    }
    
    private List<String> dfs(String departure, Map<String, List<String>> graph, List<String> visited) {
        // 방문한 공항 저장
        visited.add(departure);
        
        if (!graph.containsKey(departure)) {
            return visited;
        }
        
        List<String> routes = visited;
        
        List<String> nodeList = graph.get(departure);
        
        for (int i = 0; i < nodeList.size(); ++i) {
            String arrival = nodeList.get(i);
            
            Map<String, List<String>> copiedGraph = new HashMap();
            // 깊은 복사
            for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
                copiedGraph.put(entry.getKey(), new LinkedList(entry.getValue()));
            }
            
            copiedGraph.get(departure).remove(i);
            
            List<String> newVisited = dfs(arrival, copiedGraph, new ArrayList(visited));
            
            // 배열 길이가 더 긴게 정답
            if (routes.size() < newVisited.size()) {
                routes = newVisited;
            }
        }
        
        // 탐색할 곳이 없을 때 배열 반환
        return routes;
    }
}