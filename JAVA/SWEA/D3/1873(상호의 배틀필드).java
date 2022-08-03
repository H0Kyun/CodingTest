package ws.d0803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class SWEA1873 {

	private enum Rotation {
		Up(0), Down(1), Left(2), Right(3);
		private final int num;
		Rotation(int num) { this.num = num; }
		public int getNum() { return num; }
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase <= T; testCase++) {
			String[] s = br.readLine().split(" ");
			int height = Integer.parseInt(s[0]);
			int width = Integer.parseInt(s[1]);
			char[][] map = new char[height][width];
			int[] direction = {-1, 1, -1, 1};
			int currentTankRotation = -1;
			int currentTankPositionY = 0, currentTankPositionX = 0;
			for(int i = 0; i < height; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j = 0; j < width; j++) {
					if(map[i][j] == '.' || map[i][j] == '*' || map[i][j] == '#' || map[i][j] == '-') continue;
					if( map[i][j] == '<') {
						currentTankRotation = Rotation.Left.getNum();
					} else if( map [i][j] == '>') {
						currentTankRotation = Rotation.Right.getNum();
					} else if( map [i][j] == '^') {
						currentTankRotation = Rotation.Up.getNum();
					} else if( map [i][j] == 'v') {
						currentTankRotation = Rotation.Down.getNum();
					}
					currentTankPositionY = i;
					currentTankPositionX = j;
				}
			}
			
			int numberOfCommand = Integer.parseInt(br.readLine());
			char[] commands = br.readLine().toCharArray();
			
			for(int i = 0; i < numberOfCommand; i++) {
				int x, y;
				//checkCommand(commands[i]);
				if( commands[i] == 'U') {
					currentTankRotation = Rotation.Up.getNum();
					y = currentTankPositionY + direction[Rotation.Up.getNum()];
					if(y < 0 || map[y][currentTankPositionX] != '.') {
						map[currentTankPositionY][currentTankPositionX] = '^';
						continue;
					}
					map[currentTankPositionY][currentTankPositionX] = '.';
					currentTankPositionY = y;
					map[y][currentTankPositionX] = '^';
				} else if( commands[i] == 'D') {
					currentTankRotation = Rotation.Down.getNum();
					y = currentTankPositionY + direction[Rotation.Down.getNum()];
					if(y >= height || map[y][currentTankPositionX] != '.') {
						map[currentTankPositionY][currentTankPositionX] = 'v';
						continue;
					}
					map[currentTankPositionY][currentTankPositionX] = '.';
					currentTankPositionY = y;
					map[y][currentTankPositionX] = 'v';
				} else if( commands[i] == 'L') {
					currentTankRotation = Rotation.Left.getNum();
					x = currentTankPositionX + direction[Rotation.Left.getNum()];
					if(x < 0 || map[currentTankPositionY][x] != '.') {
						map[currentTankPositionY][currentTankPositionX] = '<';
						continue;
					}
					map[currentTankPositionY][currentTankPositionX] = '.';
					currentTankPositionX = x;
					map[currentTankPositionY][x] = '<';
				} else if( commands[i] == 'R') {
					currentTankRotation = Rotation.Right.getNum();
					x = currentTankPositionX + direction[Rotation.Right.getNum()];
					if(x >= width || map[currentTankPositionY][x] != '.') {
						map[currentTankPositionY][currentTankPositionX] = '>';
						continue;
					}
					map[currentTankPositionY][currentTankPositionX] = '.';
					currentTankPositionX = x;
					map[currentTankPositionY][x] = '>';
				} else if( commands[i] == 'S') {
					if(currentTankRotation == Rotation.Up.getNum()) {
						for(int j = currentTankPositionY; j >= 0; j--) {
							if(map[j][currentTankPositionX] == '#') break;
							if(map[j][currentTankPositionX] == '*') {
								map[j][currentTankPositionX] = '.';
								break;
							}
						}
					} else if(currentTankRotation == Rotation.Down.getNum()) {
						for(int j = currentTankPositionY; j < height; j++) {
							if(map[j][currentTankPositionX] == '#') break;
							if(map[j][currentTankPositionX] == '*') {
								map[j][currentTankPositionX] = '.';
								break;
							}
						}
					} else if(currentTankRotation == Rotation.Right.getNum()) {
						for(int j = currentTankPositionX; j < width; j++) {
							if(map[currentTankPositionY][j] == '#') break;
							if(map[currentTankPositionY][j] == '*') {
								map[currentTankPositionY][j] = '.';
								break;
							}
						}
					} else if(currentTankRotation == Rotation.Left.getNum()) {
						for(int j = currentTankPositionX; j >= 0; j--) {
							if(map[currentTankPositionY][j] == '#') break;
							if(map[currentTankPositionY][j] == '*') {
								map[currentTankPositionY][j] = '.';
								break;
							}
						}
					}
					
				}
			}
			
			
			sb.append("#" + testCase + " ");
			for(int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[i].length; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

}
