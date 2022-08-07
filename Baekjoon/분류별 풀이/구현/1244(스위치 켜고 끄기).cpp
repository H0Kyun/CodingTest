// 문제 출처: https://www.acmicpc.net/problem/1244

#include<iostream>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int numberOfSwitch;
	cin >> numberOfSwitch;

	bool* switchStatus = new bool[numberOfSwitch];
	for (int i = 0; i < numberOfSwitch; i++) {
		cin >> switchStatus[i];
	}

	int numberOfStudent;
	cin >> numberOfStudent;
	for (int i = 0; i < numberOfStudent; i++) {
		char sex;
		int number;
		cin >> sex >> number;

		if (switchStatus[number - 1]) switchStatus[number - 1] = 0;
		else switchStatus[number - 1] = 1;

		if (sex == '1') {
			for (int j = 2; number * j <= numberOfSwitch; j++) {
				if (switchStatus[number * j - 1]) switchStatus[number * j - 1] = 0;
				else switchStatus[number * j - 1] = 1;
			}
		}

		if (sex == '2') {
			int left = number - 1, right = number - 1;
			while (--left >= 0 && ++right < numberOfSwitch) {
				if (switchStatus[left] != switchStatus[right]) break;
				if (switchStatus[left]) {
					switchStatus[left] = 0;
					switchStatus[right] = 0;
				}
				else {
					switchStatus[left] = 1;
					switchStatus[right] = 1;
				}

			}
		}
	}

	for (int i = 0; i < numberOfSwitch; i++) {
		cout << switchStatus[i] << " ";
		if ((i + 1) % 20 == 0) cout << "\n";
	}

	delete[] switchStatus;

	return 0;
}