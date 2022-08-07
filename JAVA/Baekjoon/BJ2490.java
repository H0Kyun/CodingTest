import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		char result;
        
		for(int i = 0; i < 3; i++) {
			int oneCount = 0;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			while(st.hasMoreTokens()) {
				if(Integer.parseInt(st.nextToken()) == 1) oneCount++;
			}
			
			switch (oneCount) {
			case 0:
				result = 'D';
				break;
			case 1:
				result = 'C';
				break;
			case 2:
				result = 'B';
				break;
			case 3:
				result = 'A';
				break;
			default:
				result = 'E';
				break;	
			}
			
			System.out.println(result);
		}
	}

}
