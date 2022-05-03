// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PsIl6AXIDFAUq

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
		int money;
        int change_count[8] ={0, };
        
		cin >> money;
        
        if(money >= 50000)
        {
            change_count[0] = money / 50000;
            money %= 50000;
        }
        
        if(money >= 10000)
        {
            change_count[1] = money / 10000;
            money %= 10000;
        }
        
        if(money >= 5000)
        {
            change_count[2] = money / 5000;
            money %= 5000;
        }
    
        if(money >= 1000)
        {
            change_count[3] = money / 1000;            
            money %= 1000;
        }
        
        if(money >= 500)
        {
            change_count[4] = money / 500;            
            money %= 500;
        }
        
        if(money >= 100)
        {
            change_count[5] = money / 100;            
            money %= 100;
        }
        
        if(money >= 50)
        {
            change_count[6] = money / 50;            
            money %= 50;
        }
        
        if(money >= 10)
        {
			change_count[7] = money / 10;
            money %= 10;
        }

        cout << "#" << test_case << "\n";
            
		for(int i = 0; i < 8; i++)
            cout << change_count[i] << " ";
        
        cout << "\n";
	}
	return 0;
}