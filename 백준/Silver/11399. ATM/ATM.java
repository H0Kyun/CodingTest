import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue(n);
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        while (st.hasMoreTokens()) {
            pq.add(Integer.parseInt(st.nextToken()));
        }
        int totalTime = 0;
        int waiting = 0;
        while(!pq.isEmpty()) {
            int withdrawal = pq.poll();
            totalTime += withdrawal + waiting;
            waiting += withdrawal;
        }
        
        System.out.println(totalTime);
        
        br.close();
    }
}