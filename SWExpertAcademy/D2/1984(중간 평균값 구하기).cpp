// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pw_-KAdcDFAUq

#include<iostream>
#include<algorithm>
#include<cmath>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin >> T;
    
	for(test_case = 1; test_case <= T; ++test_case)
	{
		float number[10];
        float sum = 0;
        
        for(int i = 0; i < 10; i++)
        {
            cin >> number[i];
        }
        
        sort(number, number + 10);
        
        for(int i = 1; i < 9; i++)
        {
            sum += number[i];
        }
        
        int avg = round(sum / 8);
        
        cout << "#" << test_case << " " << avg << "\n";
	}
	return 0;
}