import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        int M = sc.nextInt();
        sc.nextLine();

        int previousStreetlightPos = sc.nextInt();
        int maxDiff = previousStreetlightPos;
        for(int i = 1; i < M; ++i) {
            int currentStreetlightPos = sc.nextInt();

            int currentDiff = currentStreetlightPos - previousStreetlightPos;
            currentDiff =  (currentDiff % 2 == 0 ? 0 : 1) + currentDiff / 2;
            maxDiff = Math.max(maxDiff, currentDiff);

            previousStreetlightPos = currentStreetlightPos;
        }
        maxDiff = Math.max(N - previousStreetlightPos, maxDiff);

        System.out.println(maxDiff);

        sc.close();
    }
}