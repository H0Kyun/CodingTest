// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5P1kNKAl8DFAUq

#include<iostream>
#include<string>

using namespace std;

int main(int argc, char** argv)
{
    int test_case;

    cin >> test_case;

    for(int i = 1; i <= test_case; i++)
    {
        string sentence;
        int pattern_length;
        
        cin >> sentence;

        for(int j = 1; j < 10; j++)
        {
            string experimental_pattern = sentence.substr(0, j);
            string control_pattern = sentence.substr(j, j);

            if(experimental_pattern == control_pattern)
            {
                pattern_length = j;
                break;
            }
        }

        cout << "#" << i << " " << pattern_length << "\n";        
    }

    return 0;
}