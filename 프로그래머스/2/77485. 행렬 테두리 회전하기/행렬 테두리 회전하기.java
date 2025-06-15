class Solution {
    private int[][] table;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        this.create(rows, columns);
        
        for (int i = 0; i < queries.length; ++i) {
            answer[i] = this.rotate(queries[i]);
        }
        
        
        return answer;
    }
    
    private int[][] create(int rows, int columns) {
        this.table = new int[rows][columns];
        int value = 1;
        
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                this.table[i][j] = value++;
            }
        }
        
        return table;
    }
    
    private int rotate(int[] query) {
        int minY = query[0] - 1;
        int minX = query[1] - 1;
        int maxY = query[2] - 1;
        int maxX = query[3] - 1;
        
        int length = (maxX - minX) * 2 + (maxY - minY) * 2;
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        int d = 0;
        int y = minY + 1;
        int x = minX;
        int temp = this.table[y][x];
        int minValue = temp;
        
        for (int i = 0; i < length - 1; ++i) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            
            if (ny > maxY || nx > maxX || ny < minY || nx < minX) {
                ++d;
                ny = y + dy[d];
                nx = x + dx[d];
            }
            
            this.table[y][x] = this.table[ny][nx];
            minValue = Math.min(this.table[ny][nx], minValue);
            
            y = ny;
            x = nx;
        }
        
        table[y][x] = temp;

        return minValue;
    }
}
