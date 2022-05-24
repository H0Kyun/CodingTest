// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXVJuEvqLAADFASe

#include<iostream>
#include<algorithm>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int testCase, T;

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        string input;

        cin >> input;

        for(int i = 0; i < input.length() - 1; i++)
        {
            if(input.length() == 0)
                break;

            for(int j = i + 1; j < input.length(); j++)
            {
                if(input[i] == input[j])
                {
                    input.erase(j, 1);
                    input.erase(i, 1);
                    i--;
                    break;
                }
            }
        }

        sort(input.begin(), input.end());
        
        if(input.empty())
            cout << "#" << testCase << " Good\n";
        else
            cout << "#" << testCase << " " << input << "\n";
    }

    return 0;
}