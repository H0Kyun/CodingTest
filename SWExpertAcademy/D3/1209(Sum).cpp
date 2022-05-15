// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13_BWKACUCFAYh

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int testCase;
    
    for(testCase = 1; testCase <= 10; testCase++)
    {
        cin >> testCase;

        int board[100][100];

        for(int i = 0; i < 100; i++)
            for(int j = 0; j < 100; j++)
                cin >> board[i][j];

        int rowSum[100] = {0, };
        int columnSum[100] = {0, };
        int diagonalSum[2] = {0, 0};
        int maxValueEachSum[3] = {0, };

        for(int i = 0; i < 100; i++)
        {
            for(int j = 0; j < 100; j++)
            {
                rowSum[i] += board[i][j];
            }

            if(maxValueEachSum[0] <= rowSum[i])
                maxValueEachSum[0] = rowSum[i];

            for(int j = 0; j < 100; j++)
            {
                columnSum[i] += board[j][i];
            }

             if(maxValueEachSum[1] <= columnSum[i])
                maxValueEachSum[1] = columnSum[i];

            diagonalSum[0] += board[i][i];
            diagonalSum[1] += board[i][99 - i];
        }

        if(diagonalSum[0] > diagonalSum[1])
            maxValueEachSum[2] = diagonalSum[0];
        else
            maxValueEachSum[2] = diagonalSum[1];

        int max = 0;
        for(int i = 0; i < 3; i++)
        {
            if(maxValueEachSum[i] > max)
                max = maxValueEachSum[i];
        }

        cout << "#" << testCase << " " << max << endl;
    }
    
    return 0;
}