// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7IzvG6EksDFAXB

#include<iostream>
#include<vector>

using namespace std;

int FindnumberOfCases(vector<int> numbers, int begin, int target)
{
    int numberOfCases = 0;

    if(target == 0)
        return 1;

    for(int i = begin + 1; i < numbers.size(); i++)
    {
        if(numbers[i] == target)
        {
            numberOfCases++;
            continue;
        }
        
        if(numbers[i] < target)
            numberOfCases += FindnumberOfCases(numbers, i, target - numbers[i]);
    }

    return numberOfCases;
}

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int testCase, T;

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        int number, target;
        int numberOfCases = 0;

        cin >> number >> target;

        vector<int>numbers(number, 0);

        for(int i = 0; i < number; i++)
            cin >> numbers[i];

        numberOfCases += FindnumberOfCases(numbers, -1, target);
        
        cout << "#" << testCase << " " << numberOfCases << endl;
    }

    return 0;
}