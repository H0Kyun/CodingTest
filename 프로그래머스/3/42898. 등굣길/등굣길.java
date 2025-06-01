class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] board = new int[n][m];
        
        for (int[] puddle : puddles) {
            board[puddle[1] - 1][puddle[0] - 1] = -1;
        }
        
        int[] directionX = {1, 0};
        int[] directionY = {0, 1};
        
        board[0][0] = 1;
        // 위나 왼쪽으로 움직이면 최단 거리가 안 됨
        // 아래나 오른족으로 만 움직여야 함
        // 내 왼 쪽이나 위 쪽에 붙어 있는 값을 더해 줘야 함
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[j][i] == -1) {
                    continue;
                }
                
                int temp = 0;
                for(int d = 0; d < directionX.length; ++d) {
                    int nx = i - directionX[d];
                    int ny = j - directionY[d];
                    
                    if (nx < 0 || ny < 0 || board[ny][nx] == -1) {
                        continue;
                    }

                    temp += board[ny][nx];
                }
                
                board[j][i] += temp % 1000000007;
            }
        }

        return board[n - 1][m - 1];
    }
}