// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXjS1GXqZ8gDFATi

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int testCase, T;

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        string input;
        string uniqueString;

        cin >> input;

        for(int i =0; i < 3; i++)
        {
            for(int j = i + 1; j < 4; j++)
            {
                if(input[j] == input[i])
                    uniqueString += input[i];
            }
        }

        if(uniqueString.length() == 2)
            cout << "#" << testCase << " Yes\n";
        else
            cout << "#" << testCase << " No\n";
    }

    return 0;
}