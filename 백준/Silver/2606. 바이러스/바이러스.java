import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfComputer = Integer.parseInt(br.readLine());
        int numberOfEdge = Integer.parseInt(br.readLine());

        Map<Integer, Set<Integer>> graph = createGraph(br, numberOfComputer, numberOfEdge);
        boolean[] visited = new boolean[numberOfComputer];

        int numberOfInfectedComputer = getInfectedComputer(graph, 1, visited);
        System.out.println(numberOfInfectedComputer - 1);

        br.close();
    }

    private static Map<Integer, Set<Integer>> createGraph(
        BufferedReader br,
        int numberOfComputer,
        int numberOfEdge
    ) throws IOException {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 1; i <= numberOfComputer; ++i) {
            graph.put(i, new HashSet<>());
        }

        for (int i = 0; i < numberOfEdge; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph.get(key).add(value);
            graph.get(value).add(key);
        }

        return graph;
    }

    private static int getInfectedComputer(
        Map<Integer, Set<Integer>> graph,
        int index,
        boolean[] visited
    ) {
        visited[index - 1] = true;

        Set<Integer> nodes = graph.get(index);

        int total = 1;

        if (nodes != null) {
            for (int i : nodes) {
                if (visited[i - 1]) {
                    continue;
                }
                total += getInfectedComputer(graph, i, visited);
            }
        }

        return total;
    }
}