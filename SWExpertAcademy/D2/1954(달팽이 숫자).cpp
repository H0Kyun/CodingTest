// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PobmqAPoDFAUq

#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin>>T;
    
    int dir_row[] = {0, 1, 0, -1};
    int dir_column[] = {1, 0, -1, 0};
    
	for(test_case = 1; test_case <= T; ++test_case)
	{
		int number;
        
        cin >> number;
        
        vector<vector<int>> snail(number, vector<int>(number, 0));
         snail[0][0] = 1;
        
        int row = 0, column = 0, idx = 0;
        
        for(int i = 2; i <= number * number; i++)
        {
            int snail_row = row + dir_row[idx];
            int snail_column = column + dir_column[idx];
            
            if(snail_row >= number || snail_column >= number || snail_row < 0 || snail_column < 0 || snail[snail_row][snail_column] > 0)
            {
				idx++;
                if(idx == 4)
                    idx = 0;
                i--;
                continue;
            }
                
            snail[snail_row][snail_column] = i;
            
            row = snail_row;
            column = snail_column;       
        }
        
        cout << "#" << test_case << endl;
        for(int i = 0; i < number; i++)
        {
            for(int j =0; j < number; j++)
            	cout << snail[i][j] << " ";

        	cout << endl;
        }
	}
	return 0;
}