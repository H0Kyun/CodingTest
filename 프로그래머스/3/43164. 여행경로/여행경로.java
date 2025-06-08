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
        
        for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
     
        
        // 처음은 ICN 과 연결된 노드 탐색 탐색
        List<String> routes = dfs("ICN", graph, new ArrayList<String>());
        
        String[] answer = new String[routes.size()];
        
        return routes.toArray(answer);
    }
    
    private List<String> dfs(String departure, Map<String, List<String>> graph, List<String> visited) {
        visited.add(departure);
        
        if (!graph.containsKey(departure)) {
            return visited;
        }
        
        List<String> nodeList = graph.get(departure);
        
        List<String> routes = visited;
        
        for (String arrival : nodeList) {
            Map<String, List<String>> copiedGraph = new HashMap();
            for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
                copiedGraph.put(entry.getKey(), new LinkedList(entry.getValue()));
            }
            
            copiedGraph.get(departure).remove(arrival);
            
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