// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14dUIaAAUCFAYD

#include<iostream>

using namespace std;

int exponentiation(int base, int exponent)
{
    if(exponent == 0)
        return 1;
    return base * exponentiation(base, exponent - 1);
}

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for(int testCase = 1; testCase <= 10; testCase++)
    {
        cin >> testCase;

        int base, exponent;

        cin >> base >> exponent;

        int result = exponentiation(base, exponent);
        
        cout << "#" << testCase << " " << result << "\n";
    }

    return 0;
}