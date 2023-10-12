import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int numberOfBuilding = 0;
        int currentHeight = 0;
        Stack<Integer> buildingHeightDiff = new Stack<>();

        for(int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(currentHeight < y) {
                buildingHeightDiff.push(y);
            } else if(currentHeight > y) {
                while (!buildingHeightDiff.isEmpty() && buildingHeightDiff.peek() > y) {
                    buildingHeightDiff.pop();
                    ++numberOfBuilding;
                }

                if(y != 0 && (buildingHeightDiff.isEmpty() || buildingHeightDiff.peek() != y)) {
                    buildingHeightDiff.push(y);
                }
            }

            currentHeight = y;
        }

        while(!buildingHeightDiff.isEmpty()) {
            buildingHeightDiff.pop();
            ++numberOfBuilding;
        }

        bw.write(String.valueOf(numberOfBuilding));

        br.close();
        bw.flush();
        bw.close();
    }
}