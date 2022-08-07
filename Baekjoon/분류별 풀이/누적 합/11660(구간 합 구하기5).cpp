// 문제 출처: https://www.acmicpc.net/problem/11660
#include<iostream>
#include<vector>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int boardSize, count;
	cin >> boardSize >> count;

	vector<vector<int>> sum(boardSize + 1, vector<int>(boardSize + 1));
	for (int i = 0; i < boardSize; i++)
	{
		for (int j = 0; j < boardSize; j++)
		{
			int input;
			cin >> input;
			sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + input;
		}
	}

	for (int i = 0; i < count; i++)
	{
		int x1, y1, x2, y2;
		cin >> x1 >> y1 >> x2 >> y2;

		int result = sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1];
		cout << result << "\n";
	}

	return 0;
}