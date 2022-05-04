//문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PhcWaAKIDFAUq

#include<iostream>
#include <list>
 
using namespace std;
  
int main(int argc, char** argv)
{
    int number = 0, i = 0;
    list <int> divisors;
    cin >> number;
 
    for(i = 1; i * i <= number; i++)
    {
        if(number % i == 0)
        {
            cout << i << " ";
            divisors.push_front(number/i);
        }
    }
     
    for(int divisor : divisors)
        cout << divisor << " ";
     
    return 0;
}