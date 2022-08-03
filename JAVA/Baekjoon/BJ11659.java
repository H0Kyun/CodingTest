package ws.d0803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11659 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		//String[] s = br.readLine().split(" ");
//		int length = Integer.parseInt(s[0]);
//		int count = Integer.parseInt(s[1]);
		int length = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());
		//s = br.readLine().split(" ");
		st = new StringTokenizer(br.readLine(), " ");
		long[] number = new long[length];
		long[] sum = new long[length];
		//number[0] = Long.parseLong(s[0]);
		number[0] = Long.parseLong(st.nextToken());
		sum[0] = number[0];
		for(int i = 1; i < length; i++) {
			//number[i] = Long.parseLong(s[i]);
			number[i] = Long.parseLong(st.nextToken());
			sum[i] = sum[i - 1] + number[i];
			
		}
		
		for(int j = 0; j < count; j++) {
			//s = br.readLine().split(" ");
			st = new StringTokenizer(br.readLine(), " ");
			//int start = Integer.parseInt(s[0]) - 1;
			int start = Integer.parseInt(st.nextToken()) - 1;
			//int end = Integer.parseInt(s[1]) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			
			long result = 0;
			result = sum[end] - ((start - 1 == -1) ? 0 : sum[start - 1]); 
			sb.append(result);
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
