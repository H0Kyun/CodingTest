// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pl0Q6ANQDFAUq

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;
	
    int prime[5] = {2, 3, 5, 7, 11};
    
	for(test_case = 1; test_case <= T; ++test_case)
	{
		int exponent[5] = {0, };
        int number;
        
        cin >> number;
        
        for(int i = 0; i < 5; i++)
        {
            while(number % prime[i] == 0)
            {
                number /= prime[i];
                exponent[i]++;
            }
            
            cout << exponent[i] << " ";
        }
        
        
	}
	return 0;
}