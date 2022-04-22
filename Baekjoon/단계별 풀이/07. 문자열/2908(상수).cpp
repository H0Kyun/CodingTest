// 문제 출처: https://www.acmicpc.net/problem/2908

#include <iostream>
#include <string.h>

using namespace std;

int main(int argc, char const *argv[])
{
    int num1 = 0, num2 = 0;

    scanf("%d %d", &num1, &num2);

    num1 = (num1 % 10) * 100 + (num1 - (num1 / 100) * 100 - (num1 % 10)) + num1 / 100;
    num2 = (num2 % 10) * 100 + (num2 - (num2 / 100) * 100 - (num2 % 10)) + num2 / 100;

    if(num1 > num2)
    {
        cout << num1;
    }
    else
    {
        cout << num2;
    }
    return 0;
}