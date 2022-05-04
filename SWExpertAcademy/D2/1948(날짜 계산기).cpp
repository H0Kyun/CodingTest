// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PnnU6AOsDFAUq

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
    
	cin >> T;
    
	for(test_case = 1; test_case <= T; ++test_case)
	{
        int left_month, left_day, right_month, right_day;
        int last_day[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        cin >> left_month >> left_day >> right_month >> right_day;
        
        int sum = 0;
        
        if(right_month - left_month > 0)
        {
            sum = last_day[left_month - 1] - left_day + right_day;
            for(int i = left_month + 1; i < right_month; i++)
                sum += last_day[i - 1];
        }
        else
        {
            sum = right_day - left_day;
        }
        
        cout << "#" << test_case << " " << sum + 1 << endl;

	}
    
	return 0;
}