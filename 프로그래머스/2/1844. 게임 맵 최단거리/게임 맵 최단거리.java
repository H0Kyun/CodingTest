import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public static class Position {
        public int x;
        public int y;
        public int count;

        public Position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        if (maps[0][0] == 0) {
            return answer;
        }
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<Position> q = new ArrayDeque<Position>();
        q.add(new Position(0, 0, 1));
        maps[0][0] = 0;
        
        while(!q.isEmpty()) {
            int size = q.size();
            while (--size >= 0) {
                Position current = q.poll();
                
                if (current.y == n -1 && current.x == m - 1) {
                    answer = current.count;
                    break;
                }

                int[] dx = { 0, 1, -1, 0};
                int[] dy = { 1, 0, 0, -1};

                for(int i = 0; i  < 4; ++i) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    if (ny < 0 || nx < 0 || ny >= n || nx >= m || maps[ny][nx] == 0) {
                        continue;
                    }

                    maps[ny][nx] = 0;
                    q.add(new Position(nx, ny, current.count + 1));
                }
            }
        }
        
        return answer;
    }
}