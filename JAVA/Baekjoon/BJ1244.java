import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, Exception {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
		int numberOfSwitch = Integer.parseInt(br.readLine());
		int[] switchStatus = new int[numberOfSwitch];
		String[] s = br.readLine().split(" ");
		for(int i = 0; i < switchStatus.length; i++) {
			switchStatus[i] = Integer.parseInt(s[i]);
		}
		
		int numberOfStudent = Integer.parseInt(br.readLine());
		for(int i = 0; i < numberOfStudent; i++) {
			String[] sexAndNumber = br.readLine().split(" ");
			char sex = sexAndNumber[0].charAt(0);
			int number = Integer.parseInt(sexAndNumber[1]);

			if(switchStatus[number -1] == 1) switchStatus[number -1] = 0;
			else switchStatus[number -1] = 1;
			
			if(sex == '1') {
				for(int j = 2; number * j <= switchStatus.length; j++) {
					if(switchStatus[number * j - 1] == 1) switchStatus[number * j - 1] = 0;
					else switchStatus[number * j - 1] = 1;
				}
			}
			
			if(sex == '2') {
				int left = number - 1, right = number - 1;
				while(--left >= 0 && ++right < numberOfSwitch) {
					if(switchStatus[left] != switchStatus[right]) break;
					if(switchStatus[left] == 1) {
						switchStatus[left] = 0;
						switchStatus[right] = 0;
					} else {
						switchStatus[left] = 1;
						switchStatus[right] = 1;
					}
					
				}
			}
		}
		
		for(int i = 0; i < switchStatus.length; i++) {
            System.out.print(switchStatus[i] + " ");
            if((i + 1) % 20 == 0) System.out.println();
        }

	}

}