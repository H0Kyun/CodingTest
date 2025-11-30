import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<Integer>();
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < m; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int number = 0;
            if (st.hasMoreTokens()) {
                number = Integer.parseInt(st.nextToken());    
            }
           
            if (command.equals("all")) {
                set.clear();
                for (int i = 1; i <=20; ++i) {
                    set.add(i);
                }
            } else if (command.equals("add")) {
                set.add(number);
            } else if (command.equals("remove")) {
                set.remove(number);
            } else if (command.equals("check")) {
                if (set.contains(number)) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (command.equals("toggle")) {
                if (set.contains(number)) {
                    set.remove(number);
                } else {
                    set.add(number);
                }
            } else if (command.equals("empty")) {
                set.clear();
            }
        }
        
        System.out.println(sb);
    }
}