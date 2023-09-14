import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(--testCase >= 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] scoresByTeam = new int[n][k + 4];
            for(int p = 0; p < m; ++p) {
                st = new StringTokenizer(br.readLine(), " ");
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                scoresByTeam[i - 1][j - 1] = Math.max(scoresByTeam[i - 1][j - 1], s);

                if(scoresByTeam[i - 1][k] == 0) {
                    scoresByTeam[i - 1][k] = i;
                }
                
                scoresByTeam[i - 1][k + 2] = p;
                ++scoresByTeam[i - 1][k + 3];
            }

            for(int p = 0; p < n; ++p) {
                for(int q = 0; q < k; ++q) {
                    scoresByTeam[p][k + 1] += scoresByTeam[p][q];
                }
            }

            Arrays.sort(scoresByTeam, (int[] a1, int[] a2) -> {
                if(a1[k + 1] == a2[k + 1]) {
                    if(a1[k + 3] == a2[k + 3]) {
                        return a1[k + 2] - a2[k + 2];
                    } else {
                        return a1[k + 3] - a2[k + 3];
                    }
                }
                return a2[k + 1] - a1[k + 1];
            });

            int teamRank = 0;
            for(int p = 0; p < n; ++p) {
                if(scoresByTeam[p][k] != 0) {
                    ++teamRank;
                }
                if(scoresByTeam[p][k] == t) {
                    sb
                        .append(teamRank)
                        .append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);

        br.close();
    }
}