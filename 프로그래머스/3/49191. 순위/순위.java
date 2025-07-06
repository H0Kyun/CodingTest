// 코드 출처: https://born2bedeveloper.tistory.com/45
class Solution {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n][n];
        
        for (int[] record : results) {
            graph[record[0] - 1][record[1] - 1] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    // 만약 선수 j가 선수 i를 이겼고, 선수 i가 선수 k를 이겼다면, 선수 j가 선수 k를 이긴 것으로 간주
                    if (graph[j][i] == 1 && graph[i][k] == 1) {
                        graph[j][k] = 1;
                    }
                }
            }
        }
        
        int answer = 0;
        
        for(int i = 0; i < n; ++i) {
            int game = 0;
            
            for (int j = 0; j < n; ++j) {
                // i가 j를 이기거나 j가 i를 이겨야 순위 결정 가능
                if (graph[i][j] == 1 || graph[j][i] == 1) {
                    ++game;
                }
            }
            
            if (game == n - 1) {
                ++answer;
            }
        }
        
        return answer;
    }
}