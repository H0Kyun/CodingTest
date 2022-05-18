// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14hwZqABsCFAYD

#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for(int testCase = 1; testCase <= 10; testCase++)
    {
        int deadLock = 0;

        int boardSize;
        cin >> boardSize;

        vector<vector<int>>board(boardSize);

        for(int i = 0; i < boardSize; i++)
        {
            for(int j = 0; j < boardSize; j++)
            {
                int input;
                cin >> input;

                if(input != 0)
                    board[j].push_back(input);
            }
        }

        for(int i = 0; i < boardSize; i++)
        {
            if(board[i].size() > 1)
            {
                bool isN = false;
                for(int j = 0; j < board[i].size(); j++)
                {
                    if(board[i][j] == 1)
                        isN = true;
                    
                    if(board[i][j] == 2 && isN)
                    {
                        deadLock++;
                        isN = false;
                    }
                }
            }
        }

        cout << "#" << testCase << " " << deadLock << "\n";
    }

    return 0;
}