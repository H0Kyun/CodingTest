// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QGNvKAtEDFAUq

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin>>T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
		int left_hand_side, right_hand_side;

        cin >> left_hand_side >> right_hand_side;

        cout << "#" << test_case << " " << left_hand_side / right_hand_side << " " << left_hand_side % right_hand_side << "\n";
	}
	return 0;
}