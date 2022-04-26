// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QSEhaA5sDFAUq

#include<iostream>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    
    cin>>T;
    
    for(test_case = 1; test_case <= T; test_case++)
    {
        int number = 0, sum = 0;
        
        for(int i = 1; i <= 10; i++)
        {
            cin >> number;
            if(number % 2 != 0)
                sum += number;
        }
        
        cout << "#" << test_case << " " << sum << "\n";
    }
    return 0;
}