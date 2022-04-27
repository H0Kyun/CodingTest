// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QDEX6AqwDFAUq

#include<iostream>
#include<cmath>

using namespace std;

int main(int argc, char** argv)
{
	int number;

    cin >> number;
    
    for(int i = 0; i <= number; i++)
        cout << pow(2, i) << " ";
    
	return 0;
}