// https://www.acmicpc.net/problem/2839

#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    int kg = 0;
    int number = -1;

    cin >> kg;

    for(int i = kg / 5; i >= 0; i --)
    {
        if((kg - 5 * i) % 3 == 0)
        {
            number = i + (kg - 5 * i) / 3;
            break;
        }
    }

    cout << number;
    
}