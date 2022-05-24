// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AX6PP9G6p1sDFAS9

#include<iostream>

using namespace std;

int main(int agrc, char** argv)
{
    int testCase, T;

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        string matchResult;
        int count = 0;
        cin >> matchResult;

        for(int i = 0; i < matchResult.length(); i++)
        {
            if(matchResult[i] == 'o')
                count++;
        }

        if(8 - count <= 15 - matchResult.length())
            cout << "#" << testCase << " YES\n";
        else
            cout << "#" << testCase << " NO\n";
    }
    return 0;
}
