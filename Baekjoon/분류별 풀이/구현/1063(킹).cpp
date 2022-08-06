// 문제 출처: https://www.acmicpc.net/problem/1063

#include <iostream>

using namespace std;
int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	string kingPos, stonePos;
	int moveCount;
	cin >> kingPos >> stonePos >> moveCount;

	string commands[] = {"R", "L", "B", "T", "RB", "RT", "LB", "LT"};
	int colDir[] = {1, -1, 0, 0, 1, 1, -1, -1};
	int rowDir[] = {0, 0, -1, 1, -1, 1, -1, 1};

	for (int i = 0; i < moveCount; i++) {
		string command;
		cin >> command;
		for (int j = 0; j < 8; j++) {
			if (commands[j] == command) {
				char kingRow = (char)(kingPos[1] + rowDir[j]);
				char kingCol = (char)(kingPos[0] + colDir[j]);

				if (kingRow == stonePos[1] && kingCol == stonePos[0]) {
					char stoneRow = (char)(stonePos[1] + rowDir[j]);
					char stoneCol = (char)(stonePos[0] + colDir[j]);

					if (stoneRow <= '0' || stoneRow >= '9' || stoneCol < 'A' || stoneCol >= 'I') break;
					stonePos = stoneCol;
					stonePos += stoneRow;
				}

				if (kingRow <= '0' || kingRow >= '9' || kingCol < 'A' || kingCol >= 'I') break;
				kingPos = kingCol;
				kingPos += kingRow;
				break;
			}
		}
	}

	cout << kingPos << "\n" << stonePos;
}