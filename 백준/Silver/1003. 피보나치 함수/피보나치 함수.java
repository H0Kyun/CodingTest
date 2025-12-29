import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int[][] array = new int[41][2]; // 40까지의 0, 1 개수
        // 0의 1 0
        array[0][0] = 1;
        array[0][1] = 0;
        // 1의 0 1
        array[1][0] = 0;
        array[1][1] = 1;

        for(int i = 2; i < 41; ++i) {
            array[i][0] = array[i - 1][0] + array[i - 2][0];
            array[i][1] = array[i - 1][1] + array[i - 2][1];
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; ++i) {
            int n = Integer.parseInt(br.readLine());
            sb.append(array[n][0]).append(" ").append(array[n][1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}