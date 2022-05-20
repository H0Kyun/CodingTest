// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXpz3dravpQDFATi

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
        int leftHandSide, rightHandSide;
        int answer;

        cin >> leftHandSide >> rightHandSide;

        if(leftHandSide > 9 || rightHandSide > 9)
            answer = -1;
        else
            answer = leftHandSide * rightHandSide;

        cout << "#" << testCase << " " << answer << "\n";
    }

    return 0;
}