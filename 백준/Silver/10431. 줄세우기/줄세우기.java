import java.util.*;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        sc.nextLine();
        
        for(int t = 0; t < testCase; t++) {
            int testCaseNum = sc.nextInt();
            
            List<Integer> students = new ArrayList<>();
            
            for(int i = 0; i < 20; i++) {
                students.add(sc.nextInt());
            }
            
            int backMovingCount = 0;
            for(int i = 0; i < 20; i++) {
                for(int j = 0; j < i; j++) {
                    if(students.get(i) < students.get(j)) {
                        backMovingCount++;
                    }
                }
            }
            
            System.out.println(testCaseNum + " " + backMovingCount);
        }
        
        sc.close();
    }
}