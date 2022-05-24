// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWNcD_66pUEDFAV8

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int testCase, T;

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        char vowel[5] = {'a', 'e', 'i', 'o', 'u'};
        string input;
        string withoutVowel;
        bool isVowel = false;

        cin >> input;

        for(int i = 0; i < input.length(); i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(input[i] == vowel[j])
                {
                    isVowel = true;
                    break;
                }
            }

            if(isVowel)
                isVowel = false;
            else
                withoutVowel += input[i];
        }
        
        cout << "#" << testCase << " " << withoutVowel << "\n";
    }

    return 0;
}