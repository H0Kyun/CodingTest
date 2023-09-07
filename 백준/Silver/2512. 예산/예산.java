import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        
        long[] budget = new long[N];
        long totalBudgetRequired = 0L;
        
        for(int i = 0; i < N; ++i) {
            budget[i] = sc.nextLong();
            totalBudgetRequired += budget[i];
        }
        sc.nextLine();
        
        Arrays.sort(budget);
        
        long M = sc.nextLong();

        if(M >= totalBudgetRequired) {
            System.out.println(budget[N - 1]);
        } else {
            for(int i = 0; i < N; ++i) {
                long upperLimit = M / (N - i);
                
                if(upperLimit <= budget[i]) {
                    System.out.println(upperLimit);
                    break;
                }
                
                M -= budget[i];
            }
        }
        
        sc.close();
    }
}