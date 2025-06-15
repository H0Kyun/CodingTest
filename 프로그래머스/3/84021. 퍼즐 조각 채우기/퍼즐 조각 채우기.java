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
    int[][][] tables = new int[4][][];
    int size;
    
    Block(int size, int[][] table) {
        this.size = size;
        this.tables[0] = table;
        createTables();
    }
    
    private void createTables() {
        for (int i = 1; i < 4; ++i) {
            // tables[i - 1] 90도 회전 값 넣기
            this.tables[i] = rotateTable(this.tables[i - 1]);
        }
        
        // System.out.println("Block");
        // for (int[][] table : this.tables) {
        //     for (int[] column : table) {
        //         for (int data : column) {
        //             System.out.printf("%d ", data);
        //         }
        //         System.out.println();
        //     }
        //     System.out.println();
        // }
    }
    
    private int[][] rotateTable(int[][] table) {
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
    
    public boolean compareTable(int[][] table) {
        for (int t = 0; t < this.tables.length; ++t) {
            boolean isSame = true;
            
            if (this.tables[t].length != table.length || this.tables[t][0].length != table[0].length) {
                continue;
            }
            
            for (int i = 0; i < this.tables[t].length; ++i) {
                for (int j = 0; j < this.tables[t][i].length; ++j) {
                    if (this.tables[t][i][j] == table[i][j]) {
                        isSame = false;
                        break;
                    }
                }
                
                if (!isSame) {
                    break;
                }
            }
            
            if (isSame) {
                return isSame;
            }
        }
        
        return false;
    }
}

class Solution {
    public int solution(int[][] game_board, int[][] table) {    
        int answer = 0;
        List<Block> list = new ArrayList<Block>();
        // table 탐색 조각(1)만나면 탐색
        boolean[][] visited = new boolean[table.length][table[0].length];
        for (int i = 0; i < table.length; ++i) {
            for (int j = 0; j < table[i].length; ++j) {
                if (table[i][j] == 1 && !visited[i][j]) {
                    // 탐색 하면서 최소 j값, 최대 j, 최고 i 값 저장
                    int[] coordinate = bfs(new Point(i, j), table.length, table[0].length, visited, table, 0);
                    // 위 결과로 찾아낸 좌표를 이용해서 테이블 복사 가능
                    int[][] copied = new int[coordinate[2] - coordinate[0] + 1][coordinate[3] - coordinate[1] + 1];
                    for(int ci = coordinate[0]; ci <= coordinate[2]; ++ci) {
                        for(int cj = coordinate[1]; cj <= coordinate[3]; ++cj) {
                            copied[ci - coordinate[0]][cj - coordinate[1]] = table[ci][cj];
                        }
                    }
                    // System.out.println("Copied Block");
                    // for(int[] column : copied) {
                    //     for (int data : column) {
                    //         System.out.printf("%d ", data);
                    //     }
                    //     System.out.println();
                    // }
                    // 복사한 테이블로 Block객체 생성
                    list.add(new Block(coordinate[4], copied));
                }
            }
        }
        // game_board 탐색 조각(0)만나면 탐색
        visited = new boolean[game_board.length][game_board[0].length];
        for (int i = 0; i < game_board.length; ++i) {
            for (int j = 0; j < game_board[i].length; ++j) {
                if (game_board[i][j] == 0 && !visited[i][j]) {
                    // 탐색 하면서 최소 j값, 최대 j, 최고 i 값 저장
                    int[] coordinate = bfs(new Point(i, j), game_board.length, game_board[0].length, visited, game_board, 1);
                    // 위 결과로 찾아낸 좌표를 이용해서 테이블 복사 가능
                    int[][] copied = new int[coordinate[2] - coordinate[0] + 1][coordinate[3] - coordinate[1] + 1];
                    for(int ci = coordinate[0]; ci <= coordinate[2]; ++ci) {
                        for(int cj = coordinate[1]; cj <= coordinate[3]; ++cj) {
                            copied[ci - coordinate[0]][cj - coordinate[1]] = game_board[ci][cj];
                        }
                    }
                    
                    // System.out.println("Found Block");
                    // for(int[] column : copied) {
                    //     for (int data : column) {
                    //         System.out.printf("%d ", data);
                    //     }
                    //     System.out.println();
                    // }
                    // 복사한 테이블로 Block객체 생성
                    for (Block block : list) {
                        if (block.size == coordinate[4] && block.compareTable(copied)) {
                            answer += block.size;
                            list.remove(block);
                            break;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    int[] bfs(Point point, int y, int x, boolean[][] visited, int[][] table, int flag) {
        //(y,x,y,x)
        int[] coordinate = new int[5];
        coordinate[0] = point.y;
        coordinate[1] = point.x;
        coordinate[2] = point.y;
        coordinate[3] = point.x;
        coordinate[4] = 0;
        
        Queue<Point> q = new ArrayDeque<Point>();
        q.offer(point);
        visited[point.y][point.x] = true;
        
        
        int[] dy = { -1, 1, 0, 0};
        int[] dx = { 0, 0, -1, 1};
        
        while(!q.isEmpty()) {
            Point pair = q.poll();
            ++coordinate[4];
            for(int i = 0; i < 4; ++i) {
                int ny = pair.y + dy[i]; 
                int nx = pair.x + dx[i]; 
                
                if (ny < 0 || nx < 0 || nx >= x || ny >= y || visited[ny][nx] || table[ny][nx] == flag) {
                    continue;
                }
                
                if (nx < coordinate[1]) {
                    coordinate[1] = nx;
                }
                
                if (ny > coordinate[2]) {
                    coordinate[2] = ny;
                }
                
                if (nx > coordinate[3]) {
                    coordinate[3] = nx;
                }
                
                q.offer(new Point(ny, nx));
                visited[ny][nx] = true;
            }
        }
        
        return coordinate;
    }
}