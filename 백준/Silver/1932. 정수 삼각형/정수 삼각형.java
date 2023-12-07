import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int n;
    private int[][] tree;
    private int[][] dp;

    public static void main(String[] args) {
        Main solution = new Main();
        solution.input();
        System.out.println(solution.getMaximumSum());
    }

    private int getMaximumSum() {
        dp[n - 1] = tree[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            for (int j = 0; j < dp[i].length; ++j) {
                dp[i][j] = Math.max(tree[i][j] + dp[i + 1][j + 1],
                    Math.max(dp[i][j], tree[i][j] + dp[i + 1][j]));
            }
        }
        
        return dp[0][0];
    }

    private void input() {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(br.readLine());
            tree = new int[n][];
            dp = new int[n][];

            createTree(br);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createTree(BufferedReader br) throws IOException {
        for (int i = 0; i < n; ++i) {
            tree[i] = new int[i + 1];
            dp[i] = new int[i + 1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; st.hasMoreTokens(); ++j) {
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}