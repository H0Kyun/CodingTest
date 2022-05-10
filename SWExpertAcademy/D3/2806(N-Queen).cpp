#include<iostream>
#include<vector>

using namespace std;

int Count = 0;

void findQueen(vector<vector<bool>> board, int row, int column, int numberOfQueens)
{
    int boardSize = board[row].size();

    if(numberOfQueens == 0)
    {
        Count++;
        return;
    }
    
    if(row >= boardSize)
        return;
    
    for(int i = 0; i < boardSize; i++)
        board[i][column] = false;
    
    for(int j = 1; column + j < boardSize; j++)
    {
        if(row + j >= boardSize)
            break;
        board[row + j][column + j] = false;
    }

    for(int j = 1; column - j >= 0; j++)
    {
        if(row + j >= boardSize)
            break;
        board[row + j][column - j] = false;
    }

    for(int i = column + 1; i < boardSize; i++)
    {
        if(board[row + 1][i])
            findQueen(board, row + 1, i, numberOfQueens - 1);
    }

    for(int i = column - 1; i >= 0; i--)
    {
        if(board[row + 1][i])
            findQueen(board, row + 1, i, numberOfQueens - 1);
    }
}

int main(int argc, char** argv)
{
    int testCase, T;

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        Count = 0;
        int boardSize;

        cin >> boardSize;

        vector<vector<bool>> board(boardSize, vector<bool>(boardSize, true));


        //재귀 함수 사용
        for(int i = 0; i < boardSize; i++)
        	findQueen(board, 0, i, boardSize - 1);

        cout << "#" << testCase << " " << Count << endl;
    }

    return 0;
}