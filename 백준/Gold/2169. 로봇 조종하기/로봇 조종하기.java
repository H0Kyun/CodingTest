import java.util.*;

public class Main {
    static int answer;

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int[][] board = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }

        answer = 0;
        int[][] dp = new int[N][M];
        dp[0][0] = board[0][0];
        for(int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + board[0][i];
        }

        for(int i = 1; i < N; i++) {
            int[] leftStartDP = new int[M];
            int[] rightStartDP = new int[M];
            leftStartDP[0] = dp[i - 1][0] + board[i][0];
            rightStartDP[M - 1] = dp[i - 1][M - 1] + board[i][M - 1];
            for(int j = 1; j < M; j++) {
                leftStartDP[j] = Math.max(leftStartDP[j - 1], dp[i - 1][j]) + board[i][j];
                rightStartDP[M - 1 - j] = Math.max(rightStartDP[M - j], dp[i - 1][M - 1 - j]) + board[i][M - 1 - j];
            }

            for(int j = 0; j < M; j++) {
                dp[i][j] = Math.max(leftStartDP[j], rightStartDP[j]);
            }
        }

        System.out.print(dp[N - 1][M - 1]);

        sc.close();
    }
}