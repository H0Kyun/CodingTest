package ws.d0802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA1208 {
	private static int[] numberOfBox = new int[100];
	private static int dump(int dumpCount) {
		Arrays.sort(numberOfBox);
		if(numberOfBox[99] - numberOfBox[0] <= 1 || dumpCount == 0) return numberOfBox[99] - numberOfBox[0]; 
		numberOfBox[99]--;
		numberOfBox[0]++;
		return dump(--dumpCount);
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testCase = 1; testCase <= 10; testCase++) {
			int dumpCount = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 100; i++) {
				numberOfBox[i] = Integer.parseInt(st.nextToken());
			}
		
			int result = dump(dumpCount);
			System.out.println("#" + testCase + " " + result);
		}
	}

}
