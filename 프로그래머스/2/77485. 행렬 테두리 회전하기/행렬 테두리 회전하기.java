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
         
        // 위 회전
//         int last = this.table[minY][maxX];
//         for (int i = maxX; i > minX; --i) {
//             this.table[minY][i] = this.table[minY][i - 1];
//             minValue = Math.min(minValue, this.table[minY][i]);
//         }
//         this.table[minY][minX] = this.table[minY + 1][minX];
//         minValue = Math.min(minValue, this.table[minY][minX]);

//         // 오른쪽 회전
//         int first = this.table[maxY][maxX];
//         for (int i = maxY; i > minY + 1; --i) {
//             this.table[i][maxX] = this.table[i - 1][maxX];
//             minValue = Math.min(minValue, this.table[i][maxX]);
//         }
//         this.table[minY + 1][maxX] = last;
//         minValue = Math.min(minValue, this.table[minY + 1][maxX]);

//         // 아래쪽 회전
//         last = this.table[maxY][minX];
//         for (int i = minX; i < maxX - 1; ++i) {
//             this.table[maxY][i] = this.table[maxY][i + 1];
//             minValue = Math.min(minValue, this.table[maxY][i]);
//         }
//         this.table[maxY][maxX - 1] = first;
//         minValue = Math.min(minValue, this.table[maxY][maxX - 1]);
        
//         // 왼쪽 회전
//         for (int i = minY + 1; i < maxY - 1; ++i) {
//             this.table[i][minX] = this.table[i + 1][minX];
//             minValue = Math.min(minValue, this.table[i][minX]);
//         }
//         this.table[maxY - 1][minX] = last;
//         minValue = Math.min(minValue, this.table[maxY - 1][minX]);

        return minValue;
    }
}
