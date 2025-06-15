import java.util.*;

class Point {
    int y;
    int x;

    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Block {
    int[][] table;
    int size;
    
    Block(int size, int[][] table) {
        this.size = size;
        this.table = table;
    }
    
    public boolean compare(Block block) {
        if (this.size != block.size) {
            return false;
        }
        
        int[][] tableToCompare = this.table;
        
        for (int i = 0; i < 4; ++i) {
            if(compareTable(tableToCompare, block.table)) {
                return true;
            }
            
            tableToCompare = rotate(tableToCompare);
        }
        
        return false;
    }
    
    private boolean compareTable(int[][] table1, int[][] table2) {
        if (table1.length != table2.length || table1[0].length != table2[0].length) {
            return false;
        }
        
        for (int i = 0; i < table1.length; ++i) {
            for (int j = 0; j < table1[0].length; ++j) {
                if (table1[i][j] != table2[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private int[][] rotate(int[][] table) {
        int row = table.length;
        int col = table[0].length;

        int[][] rotatedTable = new int[col][row];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rotatedTable[j][row - 1 - i] = table[i][j];
            }
        }
        
        return rotatedTable;
    }
}

class Solution {
    static class CropInformation {
        int minY;
        int minX;
        int maxY;
        int maxX;
        
        CropInformation(int minY, int minX, int maxY, int maxX) {
            this.minY = minY;
            this.minX = minX;
            this.maxY = maxY;
            this.maxX = maxX;
        }
    }
    
    public int solution(int[][] game_board, int[][] table) {    
        List<Block> tableBlocks = findBlock(table, 1);
        List<Block> gameBoardBlocks = findBlock(game_board, 0);

        int answer = 0;
        
        for (Block gameBoardBlock : gameBoardBlocks) {
            for (Block tableBlock : tableBlocks) {
                if (gameBoardBlock.compare(tableBlock)) {
                    answer += gameBoardBlock.size;
                    
                    tableBlocks.remove(tableBlock);
                    
                    break;
                }
            }
            
        }
        
        return answer;
    }
    
    List<Block> findBlock(int[][] table, int target) {
        List<Block> list = new ArrayList<Block>();
        
        int row = table.length;
        int column = table[0].length;
        
        boolean[][] visited = new boolean[row][column];
        
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < column; ++j) {
                if (table[i][j] == target && !visited[i][j]) {
                    // 탐색 하면서 최소 j값, 최대 j, 최고 i 값 저장
                    CropInformation cropInfo = bfs(new Point(i, j), visited, table, target);
                    
                    // 복사한 테이블로 Block객체 생성
                    list.add(cropTable(cropInfo, table, target));
                }
            }
        }
        
        return list;
    }
    
    CropInformation bfs(Point point, boolean[][] visited, int[][] table, int target) {
        int minY = point.y;
        int minX = point.x;
        int maxY = point.y;
        int maxX = point.x;
        
        int row = table.length;
        int column = table[0].length;
        
        Queue<Point> q = new ArrayDeque<Point>();
        q.offer(point);
        
        visited[point.y][point.x] = true;
        
        int[] dy = { -1, 1, 0, 0};
        int[] dx = { 0, 0, -1, 1};
        
        while(!q.isEmpty()) {
            Point pair = q.poll();
            
            for(int i = 0; i < 4; ++i) {
                int ny = pair.y + dy[i]; 
                int nx = pair.x + dx[i]; 
                
                if (ny < 0 || nx < 0 || ny >= row || nx >= column) {
                    continue;
                }
                
                if (visited[ny][nx] || table[ny][nx] != target) {
                    continue;
                }
                
                minY = Math.min(ny, minY);
                minX = Math.min(nx, minX);
                maxY = Math.max(ny, maxY);
                maxX = Math.max(nx, maxX);
                
                q.offer(new Point(ny, nx));
                
                visited[ny][nx] = true;
            }
        }
        
        return new CropInformation(minY, minX, maxY, maxX);
    }
    
    Block cropTable(CropInformation cropInfo, int[][] table, int target) {
        int count = 0;
        int[][] copied = new int[cropInfo.maxY - cropInfo.minY + 1][cropInfo.maxX - cropInfo.minX + 1];
        
        for(int i = cropInfo.minY; i <= cropInfo.maxY; ++i) {
            for(int j = cropInfo.minX; j <= cropInfo.maxX; ++j) {
                if (table[i][j] == target) {
                    ++count;
                }
                
                copied[i - cropInfo.minY][j - cropInfo.minX] = target == 0 ? 1 - table[i][j] : table[i][j];
            }
        }
        
        return new Block(count, copied);
    }
}