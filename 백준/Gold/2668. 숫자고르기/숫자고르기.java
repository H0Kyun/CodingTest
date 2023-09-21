import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] graph = new int[N];

        for(int i = 0; i < N; ++i) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visited = new boolean[N];
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < N; ++i) {
            if(visited[i]) {
                continue;
            }

            List<Integer> result = dfs(i, i, visited, graph);
            if(result != null) {
                answer.addAll(result);
            }
        }

        sb.append(answer.size()).append("\n");

        answer.sort((i1, i2) -> i1 - i2);
        for(Integer i : answer) {
            sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    private static List<Integer> dfs(int start, int cur, boolean[] visited, int[] graph) {
        if(visited[cur]) {
            if(cur == start) {
                List<Integer> list = new ArrayList<>();
                return list;
            }

            return null;
        }

        visited[cur] = true;
        List<Integer> list = dfs(start, graph[cur] - 1, visited, graph);
        if(list == null) {
            visited[cur] = false;
            return null;
        } else {
            list.add(cur + 1);
            return list;
        }
    }

}