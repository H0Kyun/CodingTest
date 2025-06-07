class Solution {
    private boolean[] visited;
    private int n;
    private int[][] computers;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        this.computers = computers;
        this.visited = new boolean[n];
        
        int answer = 0;
        
        for (int i = 0 ; i < n; ++i) {
            if (!this.visited[i]) {
                this.dfs(i);

                ++answer;
            }
        }
        
        return answer;
    }
    
    private void dfs(int start) {
        this.visited[start] = true;
        
        for (int i = 0; i < this.n; ++i) {
            if (!this.visited[i] && this.computers[start][i] == 1) {
                this.dfs(i);
            }
        }
    }
}