// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14_DEKAJcCFAYD

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int testCase;

    for(testCase = 1; testCase <= 10; testCase++)
    {
        int passwordLength;
        string password;

        cin >> passwordLength >> password;

        for(int i = 0; i + 1 < password.length(); i++)
        {
            if(password[i] == password[i + 1])
            {
                password.erase(i, 2);
                i -= 2;
            }
        }

        cout << "#" << testCase << " " << password << "\n";
    }

    return 0;
}