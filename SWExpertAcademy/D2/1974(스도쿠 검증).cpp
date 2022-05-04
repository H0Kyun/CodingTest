// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Psz16AYEDFAUq

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
		int sudoku_board[9][9];
        bool is_valid = true;
        
        for(int i = 0; i < 9; i++)
            for(int j = 0; j < 9; j++)
                cin >> sudoku_board[i][j];
        
        for(int i = 0; i < 9; i++)
        {
            bool check_sudoku[9] = {false, };
            
            for(int j = 0; j < 9; j++) // 가로 검사
            {		
                if(check_sudoku[sudoku_board[i][j] - 1])
                {
                    is_valid = false;
                    break;
                }
                else
                {
                    check_sudoku[sudoku_board[i][j] -1] = true;
                }
            }
            
            if(!is_valid)
            	break;
            
            for(int j = 0; j < 9; j++)
                check_sudoku[j] = false;
            
            for(int j = 0; j < 9; j++) // 세로 검사
            {
                if(check_sudoku[sudoku_board[j][i] - 1])
                {
                    is_valid = false;
                    break;
                }
                else
                {
                    check_sudoku[sudoku_board[j][i] -1] = true;
                }
            }
            
            if(!is_valid)
            	break;
        }
        
        
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                bool check_sudoku[9] = {false, };
				for(int k = 0; k < 3; k++)
                {
                    for(int q = 0; q < 3; q++)
                    {
                        if(check_sudoku[sudoku_board[i * 3 + k][j * 3 + q] - 1])
                		{
                            is_valid = false;
                            break;
                        }
                        else
                        {
                           check_sudoku[sudoku_board[i * 3 + k][j * 3 + q] - 1] = true;
                        }
                    }
                }
            }
        }
        
        cout << "#" << test_case << " " << is_valid << "\n";
	}
	return 0;
}