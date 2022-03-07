// https://www.acmicpc.net/problem/10250

#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    int testCase = 0;
    int wide = 0, height = 0;
    int number = 0;

    cin >> testCase;

    int answer[testCase];

    for (int i = 0; i < testCase; i++)
    {
        cin >> height >> wide >> number;

        answer[i] = (number % height == 0) ? (height * 100 + number / height) : (number % height) * 100 + (number / height + 1);
    }

    for (int i = 0; i < testCase; i++)
    {
        cout << answer[i] << "\n";
    }
    
}