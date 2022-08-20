// 문제 출처: https://www.acmicpc.net/problem/2164

#include<iostream>
#include<queue>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M;
	cin >> N;
	queue<int> q;
	

	for (int i = 1; i <= N; i++)
		q.push(i);

	int count = 0;
	while (q.size() != 1)
	{
		q.pop();
		q.push(q.front());
		q.pop();
	}

	cout << q.front();
	return 0;
}
