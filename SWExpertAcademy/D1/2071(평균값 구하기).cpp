// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QRnJqA5cDFAUq

#include<iostream>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    
    cin>>T;
    
    for(test_case = 1; test_case <= T; test_case++)
    {
        int number = 0, sum = 0, avg = 0;
        
        for(int i = 1; i <= 10; i++)
        {
            cin >> number;
            sum  += number;
        }

        if(sum % 10 >= 5)
            avg = sum / 10 + 1;
        else
            avg = sum / 10;
        
        cout << "#" << test_case << " " << avg << "\n";
    }
    return 0;
}