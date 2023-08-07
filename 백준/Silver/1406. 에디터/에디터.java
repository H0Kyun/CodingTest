import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String initStr = br.readLine();
        Stack<Character> cursorLeft = new Stack<>();
        Stack<Character> cursorRight = new Stack<>();
        int commandCount = Integer.parseInt(br.readLine());


        for(int i = 0; i < initStr.length(); ++i) {
            cursorLeft.push(initStr.charAt(i));
        }

        for (int i = 0; i < commandCount; ++i) {
            String command = br.readLine();

            if(command.equals("L")) {
                if(!cursorLeft.isEmpty()) {
                    cursorRight.push(cursorLeft.pop());
                }
            } else if(command.equals("D")) {
                if(!cursorRight.isEmpty()) {
                    cursorLeft.push(cursorRight.pop());
                }
            } else if(command.equals("B")) {
                if(!cursorLeft.isEmpty()) {
                    cursorLeft.pop();
                }
            } else {
                cursorLeft.push(command.charAt(2));
            }
        }

        while(!cursorLeft.isEmpty()) {
            cursorRight.push(cursorLeft.pop());
        }
        while(!cursorRight.isEmpty()) {
            bw.write(cursorRight.pop());
        }

        br.close();
        bw.flush();
        bw.close();
    }

}


