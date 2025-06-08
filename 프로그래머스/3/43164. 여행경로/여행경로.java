import java.util.*;

class Airport implements Comparable<Airport> {
    boolean isVisited;
    String name;
    
    Airport(String name) {
        this.name = name;
        this.isVisited = false;
    }
    
    boolean isNotVisited() {
        return !this.isVisited;
    }
    
    @Override
    public int compareTo(Airport other) {
        return this.name.compareTo(other.name);
    }
}

class Solution {
    public String[] solution(String[][] tickets) {
        // 공항명, 연결된 노드 저장
        Map<String, List<Airport>> graph = new HashMap();
        
        for (String[] ticket : tickets) {
            if (!graph.containsKey(ticket[0])) {
                List<Airport> list = new ArrayList();
                list.add(new Airport(ticket[1]));
                
                graph.put(ticket[0], list);
            } else {
                List<Airport> list = graph.get(ticket[0]);
                list.add(new Airport(ticket[1]));
                
                // 저장 후 각 List는 이름순 정렬을 해야 함
                Collections.sort(list);
            }
        }
        
        // 처음은 ICN 과 연결된 노드 탐색 탐색
        List<String> routes = dfs("ICN", graph, new ArrayList<String>());
        
        return routes.toArray(new String[routes.size()]);
    }
    
    private List<String> dfs(
        String departure,
        Map<String, List<Airport>> graph, 
        List<String> visited
    ) {
        // 방문한 공항 저장
        visited.add(departure);
        
        if (!graph.containsKey(departure)) {
            return visited;
        }
        
        List<String> routes = visited;
        
        for (Airport arrival : graph.get(departure)) {
            if (arrival.isNotVisited()) {
                arrival.isVisited = true;
                
                List<String> newVisited
                    = dfs(arrival.name, graph, new ArrayList(visited));
                
                arrival.isVisited = false;
                
                // 배열 길이가 더 긴게 정답
                if (routes.size() < newVisited.size()) {
                    routes = newVisited;
                }
            }
        }
        
        // 탐색할 곳이 없을 때 배열 반환
        return routes;
    }
}