//문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QFZtaAscDFAUq

#include<iostream>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int number = 0, sum = 0;
    cin >> number;
     
    for(test_case = number; test_case > 0; --test_case)
    {
        sum += test_case;
    }
     
    cout << sum;
    return 0;
}