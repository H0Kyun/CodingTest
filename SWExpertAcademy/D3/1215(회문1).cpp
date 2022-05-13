// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14QpAaAAwCFAYi

#include<iostream>
#include<algorithm>
#include<string>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for(int testCase = 1; testCase <= 10; testCase++)
    {
        int lengthOfPalindrome, numberOfPalindrome = 0;
        string rowBoard[8];
        string columnBoard[8];

        cin >> lengthOfPalindrome;

        if(lengthOfPalindrome == 1)
        {
            numberOfPalindrome = 64;
            cout << "#" << testCase << " " << numberOfPalindrome << endl;
            continue;
        }

        for(int i = 0; i < 8; i++)
           cin >> rowBoard[i];

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
                columnBoard[i] += rowBoard[j][i];
        }

        bool isPalindrome = false;
        int lengthToCompare = lengthOfPalindrome / 2 + lengthOfPalindrome % 2;

        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j + lengthOfPalindrome <= 8; j++)
            {
                string front = rowBoard[i].substr(j, lengthOfPalindrome / 2);
                string back = rowBoard[i].substr(j + lengthToCompare, lengthOfPalindrome / 2);
                
                reverse(back.begin(), back.end());
                
                if(front == back)
                    isPalindrome = true;
                
                if(isPalindrome)
                {
                    numberOfPalindrome++;
                    isPalindrome = false;
                }
            }

            for(int j = 0; j + lengthOfPalindrome <= 8; j++)
            {
                string front = columnBoard[i].substr(j, lengthOfPalindrome / 2);
                string back = columnBoard[i].substr(j + lengthToCompare, lengthOfPalindrome / 2);
                
                reverse(back.begin(), back.end());
                
                if(front == back)
                    isPalindrome = true;
                
                if(isPalindrome)
                {
                    numberOfPalindrome++;
                    isPalindrome = false;
                }
            }
        }

        

        cout << "#" << testCase << " " << numberOfPalindrome << endl;
    }

    return 0;
}