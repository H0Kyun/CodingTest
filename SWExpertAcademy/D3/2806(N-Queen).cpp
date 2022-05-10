#include<iostream>
#include<vector>

using namespace std;

void findQueen(vector<vector<bool>> &board, int row, int column)
{
    int boardSize = board[row].size();
    for(int i = 0; i < boardSize; i++)
    {
        board[row][i] = false;
        board[i][column] = false;
    }

    for(int i = 0; i < boardSize; i++)
    {
        for(int j = 1; column + j < boardSize; j++)
        {
            board[i][column + j] = false;
        }

        for(int j = 1; column - j > boardSize; j++)
        {
            board[i][column - j] = false;
        }
    }

    

    for(int i = row + 1; i < boardSize; i++)
    {
        if(board[i][0])
            break;
    }

    board[row][column] = true;
}

int main(int argc, char** argv)
{
    int testCase, T;

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        int boardSize;

        cin >> boardSize;

        vector<vector<bool>> board(boardSize, vector<bool>(boardSize, true));


        //재귀 함수 사용
        findQueen(board, 0, 0);

        cout << "#" << testCase << " " << endl;
    }

    return 0;
}