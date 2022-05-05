// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV13zo1KAAACFAYh

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    // 실행시간 단축용
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
	int test_case;
	int T;
	
	cin >>T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
        cin >> test_case;
		
        int scores[101] = {0, };
        
        for(int i = 1; i <= 1000; i++)
        {
            int score;
            cin >> score;

            scores[score]++;
        }

        int mode_score = 0;
        int mode = 0;

        for(int i = 0; i < 101; i++)
        {
            if(mode <= scores[i])
            {
                mode = scores[i];
                mode_score = i;
            }
        }

        cout << "#" << test_case << " " << mode_score << "\n";
	}
	return 0;
}