// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5Pq-OKAVYDFAUq

#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
        int number;
        
        cin >> number;
        
        vector<vector<int>>matrix(number, vector<int>(number, 0));
        vector<vector<int>>matrix_rotate90(number, vector<int>(number, 0));
        vector<vector<int>>matrix_rotate180(number, vector<int>(number, 0));
        vector<vector<int>>matrix_rotate270(number, vector<int>(number, 0));
        
        for(int i = 0; i < number; i++) // 배열 입력
            for(int j = 0; j < number; j++)
                cin >> matrix[i][j];
        
       for(int i = 0; i < number; i++) // 90도 회전
            for(int j = 0; j < number; j++)
        		matrix_rotate90[i][number - j - 1] = matrix[j][i];
        
       for(int i = 0; i < number; i++) // 180도 회전
            for(int j = 0; j < number; j++)
        		matrix_rotate180[i][number - j - 1] = matrix_rotate90[j][i];
        
        for(int i = 0; i < number; i++) // 270도 회전
            for(int j = 0; j < number; j++)
        		matrix_rotate270[i][number - j - 1] = matrix_rotate180[j][i];
        
        cout << "#" << test_case << endl;
        
        for(int i = 0; i < number; i++) // 출력
        {
            for(int j = 0; j < number; j++)
        		cout << matrix_rotate90[i][j];
        
            cout << " ";
            
        	for(int j = 0; j < number; j++)
        		cout << matrix_rotate180[i][j];
            
            cout << " ";
            
            for(int j = 0; j < number; j++)
        		cout << matrix_rotate270[i][j];
            
            cout << endl;
        }
	}
	return 0;
}