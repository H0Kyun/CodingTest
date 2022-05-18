// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14Rq5aABUCFAYi

#include<iostream>
#include<algorithm>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for(int testCase = 1; testCase <= 10; testCase++)
    {
        int longestPalindromeLegnth = 1;

        cin >> testCase;

        char board[100][100];

        for(int i = 0; i < 100; i++)
            for(int j = 0; j < 100; j++)
                cin >> board[i][j];

        for(int i = 0; i < 100; i++)
        {
            for(int j = 0; j < 100; j++)
            {
                int front = j;
                int back = 99;
                int loop = 1;
                int length = back - j + 1;

                while(1)
                {
                    if(longestPalindromeLegnth > length)
                        break;

                    if(board[i][front] == board[i][back])
                    {
                        front++;
                        back--;
                    }
                    else
                    {
                        front = j;
                        back = 99 - loop;
                        length = back - j + 1;
                        loop++;
                    }

                    
                    if(front >= back)
                    {
                        longestPalindromeLegnth = length;
                        break;
                    }
                }

                front = j;
                back = 99;
                loop = 1;
                length = back - j + 1;

                while(1)
                {
                    if(longestPalindromeLegnth > length)
                        break;

                    if(board[front][i] == board[back][i])
                    {
                        front++;
                        back--;
                    }
                    else
                    {
                        front = j;
                        back = 99 - loop;
                        length = back - j + 1;
                        loop++;
                    }

                    if(front >= back)
                    {
                        longestPalindromeLegnth = length;
                        break;
                    }
                }
            }
        }

        cout << "#" << testCase << " " << longestPalindromeLegnth << endl;
    }

    return 0;
}