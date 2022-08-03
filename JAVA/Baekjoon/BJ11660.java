package ws.d0803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11660 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int boardSize = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		long[][] sum = new long[boardSize + 1][boardSize + 1];
		for(int i = 0; i < boardSize; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < boardSize; j++) {
				sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + Long.parseLong(st.nextToken());
			}
		}
		
		for(int i = 0; i < count; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			long result = sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1];
			sb.append(result).append('\n');
		}
		
		System.out.println(sb);
		

	}

}
