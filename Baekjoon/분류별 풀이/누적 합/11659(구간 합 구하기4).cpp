//문제 출처: https://www.acmicpc.net/problem/11659

#include<iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int length;
	int count;

	cin >> length >> count;

	long long* number = new long long[length];
	long long* sum = new long long[length];
	cin >> number[0];
	sum[0] = number[0];
	for (int i = 1; i < length; i++)
	{
		cin >> number[i];
		sum[i] = sum[i - 1] + number[i];
	}

	for (int j = 0; j < count; j++) {
		int start;
		int end;

		cin >> start >> end;
		start--; end--;

		long long result = 0;
		result = sum[end] - ((start - 1 == -1) ? 0 : sum[start - 1]);
		cout << result << "\n";
	}

	delete[] number;
	delete[] sum;

	return 0;
}
