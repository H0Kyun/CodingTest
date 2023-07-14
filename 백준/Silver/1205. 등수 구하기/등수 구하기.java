
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int newScore = sc.nextInt();
        int P = sc.nextInt();
        sc.nextLine();

        int rank = 1;
        int count = 0;
        int[] scores = new int[N];

        for(int i = 0; i < N; i++) {
            scores[i] = sc.nextInt();

            if(scores[i] > newScore) {
                rank++;
            }

            if(scores[i] < newScore) {
                if(i > 0 && scores[i - 1] > newScore) {
                    rank = i + 1;
                }
                break;
            }
            count++;
        }

        if(count == P) {
            rank = -1;
        }
        System.out.println(rank);
        sc.close();
    }

}