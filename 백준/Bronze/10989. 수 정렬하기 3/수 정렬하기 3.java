import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] array = new int[10001];
        
        for (int i = 0; i < n; ++i) {
            int input = Integer.parseInt(br.readLine());
            
            ++array[input];
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < 10001; ++i) {
            for (int j = 0; j < array[i]; ++j) {
                sb.append(i).append("\n");
            }
        }
        
        bw.write(sb.toString());
        
        bw.flush();
        bw.close();
    }
}