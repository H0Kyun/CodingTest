// 문제 출처: https://www.acmicpc.net/problem/10809

#include <iostream>
#include <string.h>

using namespace std;

int main(int argc, char const *argv[])
{
    int i = 0, j = 0;
    char word[101]; // 문제가 100보다 작다가 아니라 100을 안 넘긴다 여서 100자리를 포함할 수 있게 작성해야함
    cin >> word;

    for (i=0; i<26; i++)
    {
        for(j=0; j<strlen(word); j++)
        {
            if (i == (word[j] - 97))
            {
                cout << j << " ";
                break;
            }
        }
        if (j == strlen(word))
        {
            cout << -1 << " ";
        }
    }

    return 0;
}