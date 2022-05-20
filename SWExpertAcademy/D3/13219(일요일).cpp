// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AX0SaDW6L2oDFASs&categoryId=AX0SaDW6L2oDFASs

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
        string inputDayOfTheWeek;
        string dayOfTheWeek[7] = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int daysRemaining = 7;

        cin >> inputDayOfTheWeek;

        for(int i = 0; i < 7; i++)
        {
            if(inputDayOfTheWeek == dayOfTheWeek[i])
            {
                daysRemaining -= i;
                break;
            }
        }
        
        cout << "#" << testCase << " " << daysRemaining << "\n";
    }

    return 0;
}