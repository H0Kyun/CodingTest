import java.util.Queue;
import java.util.ArrayDeque;

class Position {
        public int x;
        public int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

class Solution {
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        int n = maps.length - 1;
        int m = maps[0].length - 1;
        
        Queue<Position> q = new ArrayDeque<Position>();
        q.add(new Position(0, 0));
        maps[0][0] = 0;
        
        // 몇 번째 칸을 탐색 중인지 depth로 확인한다.
        int depth = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            
            while(--size >= 0) {
                Position current = q.poll();

                if (current.y == n && current.x == m) {
                    answer = depth;
                    break;
                }

                int[] dx = { 0, -1, 0, 1};
                int[] dy = { 1, 0, -1, 0};

                for(int i = 0; i  < 4; ++i) {
                    int nx = current.x + dx[i];
                    int ny = current.y + dy[i];

                    if (ny < 0 || nx < 0 || ny > n || nx > m || maps[ny][nx] == 0) {
                        continue;
                    }

                    maps[ny][nx] = 0;
                    q.add(new Position(nx, ny));
                }
            }
            
            ++depth;
        }
        
        return answer;
    }
}