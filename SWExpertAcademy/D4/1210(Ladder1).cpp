#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
	int test_case;
	int T;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        cin >> test_case;
        
        int board[100][100];
        for(int i = 0; i < 100; i++)
			for(int j = 0; j < 100; j++)
                cin >> board[i][j];
        
        int startIndex = 0;
        for(int i = 0; i < 100; i++)
        	if(board[99][i] == 2) startIndex = 1;
        
        int currentIndex = startIndex;
        for(int i = 98; i >= 0; i--) {
            while(currentIndex - 1 >= 0 && board[i][currentIndex - 1] == 1) {
                --currentIndex;
            }
            if(currentIndex != startIndex) { 
                startIndex = currentIndex;
                continue;
            }
            while(currentIndex + 1 < 100 && board[i][currentIndex + 1] == 1) {
                ++currentIndex;
            }
            if(currentIndex != startIndex) { 
                startIndex = currentIndex;
                continue;
            }
        }
        
        cout << "#" << test_case << " " << currentIndex << "\n";
            
	}
	return 0;//정상종료시 반드시 0을 리턴해야합니다.
}