// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PxmBqAe8DFAUq

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin >> T;
    
	for(test_case = 1; test_case <= T; ++test_case)
	{
		int number, sum = 0;
        
        cin >> number;
        
        for(int i = 1; i <= number; i++)
        {
            if(i % 2 == 0)
                sum -= i;
            else
                sum += i;
        }
        
        cout << "#" << test_case << " " << sum << "\n";
	}
	return 0;
}