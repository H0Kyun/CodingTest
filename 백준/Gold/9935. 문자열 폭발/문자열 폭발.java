import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String originalStr = sc.nextLine();
        String tnt = sc.nextLine();

        char tntLastCharacter = tnt.charAt(tnt.length() - 1);
        Stack<Character> postBlastStack = new Stack<>();
        for(int i = 0; i < originalStr.length(); i++) {
            postBlastStack.push(originalStr.charAt(i));

            if (originalStr.charAt(i) == tntLastCharacter) {
                if(postBlastStack.size() >= tnt.length()) {
                    boolean isSame = true;
                    for (int j = 0; j < tnt.length(); j++) {
                        if (postBlastStack.get(postBlastStack.size() - tnt.length() + j) != tnt.charAt(j)) {
                            isSame = false;
                            break;
                        }

                    }

                    if(isSame) {
                        for (int j = 0; j < tnt.length(); j++) {
                            postBlastStack.pop();
                        }
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        postBlastStack.forEach(sb::append);
        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
        sc.close();
    }
}