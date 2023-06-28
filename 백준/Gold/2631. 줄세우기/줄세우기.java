import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        
        int[] studentNumber = new int[N];
        int[] dp = new int[N];
        int max = 0;
        for(int i = 0; i < N; i++) {
            studentNumber[i] = sc.nextInt();
            sc.nextLine();
            
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(studentNumber[j] < studentNumber[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            if(dp[i] > max) {
                max = dp[i];
            }
        }
        
        System.out.println(N - max);
        
        sc.close();
    }
}