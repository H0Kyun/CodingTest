// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXkcWgFa8sADFAS8

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
        int number;
        bool isValid = false;
        cin >> number;

        if(number <= 81)
        {
            for(int i = 1; i <= 9; i++)
            {
                if(number % i == 0)
                {
                    if(1 <= number / i && number / i <= 9)
                    {
                        isValid = true;
                        break;
                    }
                }
            }
        }
        

        if(isValid)
            cout << "#" << testCase << " Yes\n";
        else
            cout << "#" << testCase << " No\n";
    }

    return 0;
}