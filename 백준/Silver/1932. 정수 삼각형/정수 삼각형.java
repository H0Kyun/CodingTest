import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] tree = new int[n][];
        int[][] dp = new int[n][];
        for (int i = 0; i < n; ++i) {
            tree[i] = new int[i + 1];
            dp[i] = new int[i + 1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; st.hasMoreTokens(); ++j) {
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        dp[n - 1] = tree[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j < dp[i].length; ++j) {
                dp[i][j] = Math.max(tree[i][j] + dp[i + 1][j + 1],
                    Math.max(dp[i][j], tree[i][j] + dp[i + 1][j]));
            }
        }

        System.out.println(dp[0][0]);
    }
}