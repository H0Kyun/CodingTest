package hw.d0803;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int zone_area = Integer.parseInt(st.nextToken());
			int flyflap_area = Integer.parseInt(st.nextToken());

			int[][] zone = new int[zone_area][zone_area];

			for (int j = 0; j < zone_area; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < zone_area; k++) {
					zone[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			int max_number_of_flies_to_kill = 0;

			for (int j = 0; j + flyflap_area <= zone_area; j++) {
				for (int k = 0; k + flyflap_area <= zone_area; k++) {
					int number_of_flies_to_kill = 0;
					for (int p = j; p < j + flyflap_area; p++) {
						for (int q = k; q < k + flyflap_area; q++) {
							number_of_flies_to_kill += zone[p][q];
						}
					}
					if (max_number_of_flies_to_kill <= number_of_flies_to_kill) {
						max_number_of_flies_to_kill = number_of_flies_to_kill;
					}
				}
			}

			sb.append("#");
			sb.append(test_case);
			sb.append(' ');
			sb.append(max_number_of_flies_to_kill);
			sb.append('\n');
		}
		System.out.println(sb);
		br.close();
	}

}
