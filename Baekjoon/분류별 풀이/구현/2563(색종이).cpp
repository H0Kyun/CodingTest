// 문제 출처: https://www.acmicpc.net/problem/2563
#include<iostream>
#include<vector>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int numberOfPaper;
	cin >> numberOfPaper;

	bool paper[100][100] = { 0, };
	int area = 0;

	for (int i = 0; i < numberOfPaper; i++)
	{
		int left, bottom;
		cin >> left >> bottom;
		for (int j = left - 1; j < left + 9; j++)
		{
			for (int k = bottom - 1; k < bottom + 9; k++)
			{
				if (!paper[j][k]) {
					paper[j][k] = 1;
					area++;
				}
			}
		}
	}

	cout << area;

	return 0;
}