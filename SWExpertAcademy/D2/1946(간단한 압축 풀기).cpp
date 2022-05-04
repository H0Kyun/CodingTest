// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PmkDKAOMDFAUq

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

    cin >> T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
		int word_count;
        
        cin >> word_count;
        int length = 0;
        
        cout << "#" << test_case << endl;
        
        for(int i = 1; i <= word_count; i++)
        {
            char word;
            int word_length;
            cin >> word >> word_length;
            
            for(int j = 1; j <= word_length; j++)
            {
                length++;
                cout << word;
            	if(length == 10)
                {
                    length = 0;
            		cout << endl;
                }
            }
        }
        
        cout << endl;
	}
	return 0;
}