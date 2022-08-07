import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int numberOfPaper = Integer.parseInt(br.readLine());
		boolean[][] paper = new boolean[100][100];
		
		int area = 0;
		for(int i = 0; i < numberOfPaper; i++) {
			String[] s = br.readLine().split(" ");
			int left = Integer.parseInt(s[0]);
			int bottom = Integer.parseInt(s[1]);
			for(int j = left - 1; j < left + 9; j++) {
				for(int k = bottom - 1; k < bottom + 9; k++) {
					if (!paper[j][k]) {
						paper[j][k] = true;
						area++;
					}
				}
			}
		}
		
		System.out.println(area);
	}

}