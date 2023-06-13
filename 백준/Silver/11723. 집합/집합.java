import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfOrder = sc.nextInt();
        sc.nextLine();

        // 아래 숫자와 비트 연산을 통해 숫자 존재 여부를 확인한다.
        int isNumberExist = 0; // 숫자 존재여부를 확인하는 숫자

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < numberOfOrder; i++) {
            // 명령어와 숫자를 입력받는다.
            String[] commandAndNumber = sc.nextLine().split(" ");

            // 명령어 종류 별로 작업을 수행한다.
            switch (commandAndNumber[0]) {
                case "add":
                    isNumberExist |= 1 << Integer.parseInt(commandAndNumber[1]);
                    break;
                case "remove":
                    isNumberExist -= isNumberExist & (1 << Integer.parseInt(commandAndNumber[1]));
                    break;
                case "check":
                    sb
                        .append(
                            (isNumberExist & (1 << Integer.parseInt(commandAndNumber[1]))) > 0 ? 1 : 0
                        )
                        .append("\n");
                     
                    break;
                case "toggle":
                    isNumberExist ^= (1 << Integer.parseInt(commandAndNumber[1]));
                    break;
                case "all":
                    isNumberExist = 2097151;
                    break;
                case "empty":
                    isNumberExist = 0;
                    break;
            }
        
        }
        System.out.println(sb.toString());
        sc.close();
    }
}