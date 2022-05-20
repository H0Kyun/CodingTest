// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXzjvCCq-PwDFASs&categoryId=AXzjvCCq-PwDFASs

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
        int numberOfStudents;
        int numberOfTeams;

        cin >> numberOfStudents;

        numberOfTeams = numberOfStudents / 3;
        
        cout << "#" << testCase << " " << numberOfTeams << "\n";
    }

    return 0;
}