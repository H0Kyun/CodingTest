// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXRSXf_a9qsDFAXS

#include<iostream>
#include<cmath>

using namespace std;

int main(int argc, char** argv)
{
	int testCase, T;

	cin >> T;

	for (testCase = 1; testCase <= T; testCase++)
	{
		int number, inputBit;
        int compareBit = 1;

		cin >> number >> inputBit;
		for (int i = 1; i < number; i++)
		{
			compareBit += (int)pow(2, i);
		}

		int bitOperationResult = compareBit & inputBit;

		if (bitOperationResult == compareBit)
			cout << "#" << testCase << " ON\n";
		else
			cout << "#" << testCase << " OFF\n";
	}
	return 0;
}