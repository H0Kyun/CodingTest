import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] positionAndMoveCount = br.readLine().split(" ");
		String kingPos = positionAndMoveCount[0];
		String stonePos = positionAndMoveCount[1];
		int moveCount = Integer.parseInt(positionAndMoveCount[2]);
		
		String[] commands = {"R", "L", "B", "T", "RB", "RT", "LB", "LT"};
		int[] colDir = {1, -1, 0, 0, 1, 1, -1, -1};
		int[] rowDir = {0, 0, -1, 1, -1, 1, -1, 1};
		
		for(int i = 0; i < moveCount; i++) {
			String command = br.readLine();
			for(int j = 0; j < 8; j++) {
				if(commands[j].equals(command)) {
					char kingRow = (char) (kingPos.charAt(1) + rowDir[j]);
					char kingCol = (char) (kingPos.charAt(0) + colDir[j]);
                    
					if(kingRow == stonePos.charAt(1) && kingCol == stonePos.charAt(0)) {
						char stoneRow = (char) (stonePos.charAt(1) + rowDir[j]);
						char stoneCol = (char) (stonePos.charAt(0) + colDir[j]);
						
						if(stoneRow <= '0' || stoneRow >= '9' || stoneCol < 'A' || stoneCol >= 'I') break;
						stonePos = String.valueOf(stoneCol) + String.valueOf(stoneRow);
					}
					
					if(kingRow <= '0' || kingRow >= '9' || kingCol < 'A' || kingCol >= 'I') break;
					kingPos = String.valueOf(kingCol) + String.valueOf(kingRow);
                    break;
				}
			}
		}
		
		System.out.println(kingPos + "\n" + stonePos);
	}

}
