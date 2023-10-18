import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int[] correctPiece = {1, 1, 2, 2, 2, 8};
        for(int i = 0; st.hasMoreTokens(); ++i) {
            correctPiece[i] -= Integer.parseInt(st.nextToken());
        }
        
        for(int i : correctPiece) {
            System.out.print(i + " ");
        }
        
        br.close();
    }
}