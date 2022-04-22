// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QQhbqA4QDFAUq

#include<iostream>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    
    cin>>T;
    
    for(test_case = 1; test_case <= T; test_case++)
    {
        int number = 0, max_number = 0;
        char sign;
    
        for(int i = 1; i <= 10; i++)
        {
            cin >> number;
            if(number > max_number)
                max_number = number;
        }

        cout << "#" << test_case << " " << max_number << "\n";
    }
    return 0;
}