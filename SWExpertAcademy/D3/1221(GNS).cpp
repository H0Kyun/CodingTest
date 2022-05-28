// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14jJh6ACYCFAYD

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int testCase, T;
    string number[10] = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        string testNumber;
        int testCaseLength;
        cin >> testNumber >> testCaseLength;

        int numberCount[10] = {0, };
        for(int i = 0; i < testCaseLength; i++)
        {
            string input;
            cin >> input;

            for(int j = 0; j < 10; j++)
                if(number[j] == input) numberCount[j]++;
        }

        cout << testNumber << "\n";
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < numberCount[i]; j++)
            {
                cout << number[i] << " ";
            }
        }
        cout << "\n";
    }

    return 0;
}