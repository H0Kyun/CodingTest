// 문제 출처: https://www.acmicpc.net/problem/11720

#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    int num = 0, count = 0;
    
    cin >> num;

    char num2[num];

    cin >> num2;

    for(int i=0; i<num; i++)
    {
        count += num2[i];
    }

    count -= 48*num;

    cout << count << endl;

    return 0;

}