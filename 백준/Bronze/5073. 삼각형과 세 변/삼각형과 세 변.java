import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int firstSide = sc.nextInt();
            int secondSide = sc.nextInt();
            int thirdSide = sc.nextInt();
            
            if(firstSide == 0 && secondSide == 0 && thirdSide == 0)
                return;
            
            if(firstSide == secondSide && secondSide == thirdSide) {
                System.out.println("Equilateral");
                continue;
            }
            
            int longest = Math.max(firstSide, Math.max(secondSide, thirdSide));
            int shortest = Math.min(firstSide, Math.min(secondSide, thirdSide));
            int middle = firstSide + secondSide+ thirdSide - (longest + shortest);
            
            if(longest >= shortest + middle) {
                System.out.println("Invalid");
                continue;
            }
            
            if(longest == middle || shortest == middle) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
            
        }
    }
}