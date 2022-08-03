package ws.d0802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA2805 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			int base = Integer.parseInt(br.readLine());
			int[][] farm = new int[base][base];
			for(int i = 0; i < base; i++) {
				char[] c = br.readLine().toCharArray();
				for(int j = 0; j < c.length; j++) {
					farm[i][j] = (int)(c[j] - '0');
				}
			}
			
			if(base == 1) {
				System.out.println("#" + testCase + " " + farm[0][0]);
				continue;
			}
			
			int mid = base/2;
			int start = mid, end = mid, sum = 0;
			for(int i = 0; i <= mid; i++) {
				for(int j = start; j <= end; j++) {
					sum += farm[i][j];
				}
				start--; end++;
			}
			start += 2; end -= 2;
			for(int i = mid + 1; i < base; i++) {
				for(int j = start; j <= end; j++) {
					sum += farm[i][j];
				}
				start++; end--;
			}
			
			System.out.println("#" + testCase + " " + sum);
		}

	}

}
