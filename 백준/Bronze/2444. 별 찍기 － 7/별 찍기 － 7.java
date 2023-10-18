import java.io.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringBuilder reverseSb = new StringBuilder();
        for(int i = 0; i < n; ++i) {
            String s = String.format("%"+(2 * i + 1)+"s", "").replace(" ", "*");
            s = String.format("%"+(s.length() + n - i - 1)+"s", s) + "\n";
            sb.append(s);

            if(i != n - 1) {
                reverseSb.insert(0, s);
            }
        }

        sb.append(reverseSb);

        System.out.println(sb);
        br.close();
    }
}