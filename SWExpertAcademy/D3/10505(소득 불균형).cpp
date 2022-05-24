// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXNP4CvauaMDFAXS

#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int testCase, T;

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        int numberOfPeople, totalIncome = 0;

        cin >> numberOfPeople;

        vector<int> personalIncome(numberOfPeople, 0);
        for(int i = 0; i < numberOfPeople; i++)
        {
            cin >> personalIncome[i];

            totalIncome += personalIncome[i];
        }

        int avg = totalIncome / numberOfPeople;
        int count = 0;

        for(int i = 0; i < numberOfPeople; i++)
        {
            if(personalIncome[i] <= avg)
                count++;
        }
        
        cout << "#" << testCase << " " << count << "\n";
    }

    return 0;
}