import java.util.*;

public class Main {

    static class Data {
        int pos;
        int time;

        public Data(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        PriorityQueue<Data> pq = new PriorityQueue<>(Comparator.comparingInt(d -> d.time));
        int[] visited = new int[100001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        pq.add(new Data(N, 0));
        visited[N] = 0;
        int shortestTime = 0;
        while(!pq.isEmpty()) {
            Data cur = pq.poll();

            if(cur.pos == K) {
                shortestTime = cur.time;
                break;
            }

            int pos = cur.pos;

            if(pos + 1 <= 100000 && visited[pos + 1] > cur.time + 1) {
                pq.add(new Data(pos + 1, cur.time + 1));
                visited[pos + 1] = cur.time + 1;
            }

            if(pos - 1 >= 0 && visited[pos - 1] > cur.time + 1) {
                pq.add(new Data(pos - 1, cur.time + 1));
                visited[pos - 1] = cur.time + 1;
            }

            if(pos * 2 <= 100000 && visited[pos * 2] > cur.time) {
                pq.add(new Data(pos * 2, cur.time));
                visited[pos * 2] = cur.time;
            }

        }

        System.out.println(shortestTime);

        sc.close();
    }
}