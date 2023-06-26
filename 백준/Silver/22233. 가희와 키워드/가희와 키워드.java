import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

       Set<String> keywords = new HashSet<>();

        for (int i = 0; i < N; i++) {
            keywords.add(sc.nextLine());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String[] words = sc.nextLine().split(",");
            for(String s : words) {
                keywords.remove(s);
            }

            sb.append(keywords.size()).append("\n");
        }

        System.out.print(sb);

        sc.close();
    }
}