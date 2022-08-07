// 문제 출처: https://www.acmicpc.net/problem/2490

#include<iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	for (int i = 0; i < 3; i++)
	{
		int oneCount = 0;
		for (int j = 0; j < 4; j++)
		{
			int input;
			cin >> input;
			if (input) oneCount++;
		}
		
		char result;
		switch (oneCount)
		{
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

		cout << result << "\n";
	}

	return 0;
}
