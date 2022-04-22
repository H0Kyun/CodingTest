// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QFuZ6As0DFAUq

#include<iostream>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test = 0, sharp = 0;
    char array[6] = "+++++";
     
    for(test = 0; test < 5; ++test)
    {
        sharp = test;
        array[sharp] = '#';
        cout << array << endl;
        array[sharp] = '+';
    }
     
    return 0;
}