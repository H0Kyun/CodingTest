// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QPRjqA10DFAUq

#include<iostream>
 
using namespace std;
  
int main(int argc, char** argv)
{
    int number = 0, sum = 0, i = 0;

    cin >> number;
 
    sum = (number / 1000) + (number / 100 % 10) + (number / 10 % 10) + (number % 10);
     
    cout << sum;
    
    return 0;
}