#include<iostream>
#include<algorithm>
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
        int numberOfCustomer, timeToMake, numberOfProduction;
        bool isPossible = true;

        cin >> numberOfCustomer >> timeToMake >> numberOfProduction;

        vector<int>arrivedTime(numberOfCustomer, 0);

        for(int i = 0; i < numberOfCustomer; i++)
            cin >> arrivedTime[i];

        sort(arrivedTime.begin(), arrivedTime.end());

        for(int i = 0; i < numberOfCustomer; i++)
        {
            if((arrivedTime[i] / timeToMake) * numberOfProduction < i + 1)
            {
                isPossible = false;
                break;
            }
        }

        cout << "#" << testCase << " ";
        if(isPossible)
            cout << "Possible" << "\n";
        else
            cout << "Impossible" << "\n";
    }

    return 0;
}