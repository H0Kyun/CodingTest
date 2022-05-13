// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GLXqKAWYDFAXB

#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int testCase, T;

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        int farmSize;

        cin >> farmSize;

        string cropValueOfRow[farmSize];
        vector<vector<int>>valueOfCrops(farmSize, vector<int>(farmSize, 0));

        for(int i = 0; i < farmSize; i++)
            cin >> cropValueOfRow[i];

        for(int i = 0; i < farmSize; i++)
            for(int j = 0; j < farmSize; j++)
                valueOfCrops[i][j] = cropValueOfRow[i][j] - '0';

        int sumOfCropValues = 0;

        for(int i = 0; i <= farmSize / 2; i++)
        {
            int rhombus = farmSize / 2 - i;

            for(int j = rhombus; j < farmSize - rhombus; j++)
                sumOfCropValues += valueOfCrops[i][j];
        }

        for(int i = farmSize / 2 + 1; i < farmSize; i++)
        {
            int rhombus = i - farmSize / 2;

            for(int j = rhombus; j < farmSize - rhombus; j++)
                sumOfCropValues += valueOfCrops[i][j];
        }

        cout << "#" << testCase << " " << sumOfCropValues << endl;
    }
    
    return 0;
}