import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Comparator;

class Solution {
    boolean[][] visited;
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        visited = new boolean[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++) {
            for(int j = 0; j < maps[0].length(); j++) {
                if(visited[i][j]) continue;
                if(maps[i].charAt(j) != 'X') {
                    answer.add(bfs(i, j, maps));
                }
                
            }
        }
        
        if(answer.size() == 0) answer.add(-1);
        answer.sort(Comparator.naturalOrder());
        return answer.stream().mapToInt(i->i).toArray();
    }
    
    static class Data {
        int y;
        int x; 
        int food;
        
        public Data(int y, int x, int food) {
            this.y = y;
            this.x = x;
            this.food = food;
        }
    }
    private int bfs(int y, int x, String[] maps) {
        Queue<Data> q = new ArrayDeque<>();
        int totalFood = maps[y].charAt(x) - '0';
        visited[y][x] = true;
        q.offer(new Data(y, x, totalFood));
        
        while(!q.isEmpty()) {
            Data cur = q.poll();
            
            int[] dy = {0, 0, 1, -1};
            int[] dx = {1, -1, 0, 0};
            
            for(int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                
                if(ny < 0 || ny >= maps.length || nx < 0 || nx >= maps[0].length() || visited[ny][nx] || maps[ny].charAt(nx) == 'X') continue;
                totalFood += maps[ny].charAt(nx) - '0';
                visited[ny][nx] = true;
                q.offer(new Data(ny, nx, maps[ny].charAt(nx) - '0'));
            }
        }
        return totalFood;
    }
}