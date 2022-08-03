package ws.d0802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEALadder1 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int testCase = 1; testCase <= 10; testCase++) {
			testCase = Integer.parseInt(br.readLine());
		
			int[][] board = new int[100][100];
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < 100; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int startIndex = 0;
			for(int i = 0; i < 100; i++) {
				if (board[99][i] == 2) startIndex = i; 
			}
			
			int currentIndex = startIndex;
			for(int i = 98; i >= 0; i--) {
				while(currentIndex - 1 >= 0 && board[i][currentIndex - 1] == 1) {
					--currentIndex;
				}
				if(currentIndex != startIndex) { 
					startIndex = currentIndex;
					continue;
				}
				while(currentIndex + 1 < 100 && board[i][currentIndex + 1] == 1) {
					++currentIndex;
				}
				if(currentIndex != startIndex) { 
					startIndex = currentIndex;
					continue;
				}
			}
			
			System.out.println("#" + testCase + " " + currentIndex);
		}
	}

}
