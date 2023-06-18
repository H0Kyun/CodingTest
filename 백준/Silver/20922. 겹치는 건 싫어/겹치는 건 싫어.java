import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        sc.nextLine();

        int[] count = new int[100001];
        List<Integer> list = new ArrayList<>();
        int answer = 0;
        int lastIndex = 0;
        for(int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int currentValue = ++count[a];
            list.add(a);


            if(currentValue > K) {
                answer = Math.max(answer, list.size() - 1);
                int removedValue = 0;
                do {
                    removedValue = list.remove(0);
                    --count[removedValue];
                } while (removedValue != a);
            }

        }

        answer = Math.max(answer, list.size());
        System.out.print(answer);
        sc.close();
    }
}