// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PTeo6AHUDFAUq

#include<iostream>
#include<string>

using namespace std;

int main(int argc, char** argv)
{
    int number;

    cin >> number;

    for(int i = 1; i <= number; i++)
    {
        string str_i = to_string(i);
        bool is369 = false;

        for(int j = 0; j < static_cast<int>(str_i.length()); j++)
        {
            char check_369 = str_i[j] - '0';
            if (check_369 == 3 || check_369 == 6 || check_369 == 9)
            {
                cout << "-";
                is369 = true;
            }
        }

        if(!is369)
            cout << i << " ";
        else
            cout << " ";
    }

    return 0;
}