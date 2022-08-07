// 문제 출처: https://www.acmicpc.net/problem/10798

#include<iostream>
#include<string>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	string board[5];
	string s;

	for (int i = 0; i < 5; i++) {
		getline(cin, s);
		board[i] = s;
	}

	s = "";

	for (int i = 0; i < 15; i++) {
		for (int j = 0; j < 5; j++) {
			if (i >= board[j].length() || board[j][i] == '\0')
				continue;
			s += board[j][i];
		}
	}

	cout << s;

	return 0;
}