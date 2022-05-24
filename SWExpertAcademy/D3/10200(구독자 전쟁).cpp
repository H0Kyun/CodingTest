// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXMCXV_qVgkDFAWv

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
        int respondents, pSubscribers, tSubscribers;

        cin >> respondents >> pSubscribers >> tSubscribers;

        int maximum = min(pSubscribers, tSubscribers);
        int minimum = pSubscribers + tSubscribers - respondents;
        if(minimum < 0) minimum = 0;
        
        cout << "#" << testCase << " " << maximum << " " << minimum << "\n";
    }

    return 0;
}