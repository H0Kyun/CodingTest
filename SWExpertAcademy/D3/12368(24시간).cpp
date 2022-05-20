// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXsEBlLqedsDFARX

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
        int currentHour, passHour;
        int futureHour;
        cin >> currentHour >> passHour;

        futureHour = currentHour + passHour >= 24 ? currentHour + passHour - 24 : currentHour + passHour;

        cout << "#" << testCase << " " << futureHour << "\n";
    }

    return 0;
}