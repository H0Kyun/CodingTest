// https://www.acmicpc.net/problem/1978

#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    int number = 0;
    int answer = 0;
    
    cin >> number;

    int prime;

    for(int i = 0; i < number; i++)
    {
        cin >> prime;

        int j = 2;

        for(j = 2; j < prime; j++)
        {
            if(prime % j == 0)
                break;
        }

        if(prime - j == 0)
            answer++;

    }

    cout << answer;

    return 0;
}