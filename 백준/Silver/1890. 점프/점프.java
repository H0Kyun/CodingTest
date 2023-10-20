import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        int[][] board = new int[N][N];
        long[][] dp = new long[N][N];
        
        for(int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; ++j) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;
        
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                int ni = i + board[i][j];
                int nj = j + board[i][j];
                
                if(dp[i][j] == 0 || board[i][j] == 0){
                    continue;
                } 
                
                if (ni < N) {
                    dp[ni][j] += dp[i][j];
                }
                
                if (nj < N) {
                    dp[i][nj] += dp[i][j];
                }
            }
        }
        
        
        bw.write(String.valueOf(dp[N - 1][N - 1]));
        
        
        br.close();
        bw.flush();
        bw.close();
    }
}