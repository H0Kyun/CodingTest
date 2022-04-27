// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QJ_8KAx8DFAUq

#include<iostream>

using namespace std;
  
int main(int argc, char** argv)
{
    int password = 0, number = 0;

    cin >> password >> number;

    cout << password - number + 1;
    
    return 0;
}