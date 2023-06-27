import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        int numberOfSeat = 0;

        numberOfSeat += W / (M + 1);
        numberOfSeat += W % (M + 1) > 0 ? 1 : 0;
        numberOfSeat *= H / (N + 1) + (H % (N + 1) > 0 ? 1 : 0);

        System.out.print(numberOfSeat);

        sc.close();
    }
}