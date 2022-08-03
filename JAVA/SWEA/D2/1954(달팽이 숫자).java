package hw.d0802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA1954 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.trowt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int base = Integer.parseInt(br.readLine());
			int[][] snail = new int[base][base];
			
			int[] dRow = {0, 1, 0, -1};
			int[] dCol = {1, 0, -1, 0};
			int currentSnailRow = 0, currentSnailCol = 0;
			snail[0][0] = 1;
			for(int i = 2, j = 0; i <= base * base; i++) {
				int row =currentSnailRow + dRow[j], col = currentSnailCol + dCol[j];
				
				if(row < 0 || row >= base || col < 0 || col >= base || snail[row][col] != 0) {
					j++;
					if(j == 4) j = 0;
					row = currentSnailRow + dRow[j]; col = currentSnailCol + dCol[j];
				}
				currentSnailRow = row;
				currentSnailCol = col;
				snail[row][col] = i;
			}
			
			System.out.println("#" + testCase);
			for(int i = 0; i < base; i++) {
				for(int j = 0; j < base; j++) {
					System.out.print(snail[i][j] + " ");
				}
				System.out.println();
			}
		}
		
	}

}
