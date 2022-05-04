// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PuPq6AaQDFAUq

#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;
    
	for(test_case = 1; test_case <= T; ++test_case)
	{
		int board_size, word_length;
        
        cin >> board_size >> word_length;
        
        vector<vector<int>> board_contents(board_size, vector<int>(board_size, 0));
        
        for(int i = 0; i < board_size; i++)
        {
            for(int j = 0; j < board_size; j++)
            {
                cin >> board_contents[i][j];
            }
        }

        int count = 0;
        
        for(int i = 0; i < board_size; i++)
        {
                for(int j = 0; j + word_length <= board_size; j++)  // 가로 검사
                {
                    int row_sum = 0, k;

                    for(k = j; k < j + word_length; k++)
                    {
                        row_sum += board_contents[i][k];
                    }

                    if(row_sum == word_length) // word_length(문제에서 K)만큼 1이 연속됐을 때 진입
                    {
                        if(k < board_size)
                        {
                            if(board_contents[i][k] == 0) // 그 다음 칸이 0이면 카운터 증가 아니면 단어 길이만큼 더해준다. 그러면 검사했던 칸 다음 칸부터 검사
                                count++;
                           	j += word_length;
                        }
                    	else
                        {
                            count++;
                        }
                    }
                }
            
                for(int j = 0; j + word_length <= board_size; j++) // 세로 검사
                {
                    int column_sum = 0, k;

                    for(k = j; k < j + word_length; k++)
                    {
                        column_sum += board_contents[k][i];
                    }

                    if(column_sum == word_length)
                    {
                        if(k < board_size)
                        {
                            if(board_contents[k][i] == 0)
                                count++;
                            j += word_length;
                        }
                    	else
                        {
                            count++;
                        }
                    }
                }
            }
        
        
        cout << "#" << test_case << " " << count << "\n";
    }
	return 0;
}