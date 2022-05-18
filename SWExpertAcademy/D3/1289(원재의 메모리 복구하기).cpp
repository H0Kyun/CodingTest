// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV19AcoKI9sCFAZN

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int testCase, T;

    cin >> T;
    
    for(testCase = 1; testCase <= T; testCase++)
    {
        string bit;
        cin >> bit;

        int count = 0;
        char check = '0';
        for(int i = 0; i < bit.length(); i++)
        {
            if(bit[i] != check)
            {
                if(check == '0')
                    check = '1';
                else
                    check = '0';
                count++;
            }
        }
        cout << "#" << testCase << " " << count << "\n";
    }

    return 0;
}