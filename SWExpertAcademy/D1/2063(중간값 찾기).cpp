// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QPsXKA2UDFAUq

#include<iostream>
#include<algorithm>

using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    
    cin >> T;
    
    int number[T];
    
    for(test_case = 0; test_case < T; test_case++)
    {
        cin >> number[test_case];
    }
    
    sort(number, number+T);

    cout << number[T / 2];

    return 0;
}