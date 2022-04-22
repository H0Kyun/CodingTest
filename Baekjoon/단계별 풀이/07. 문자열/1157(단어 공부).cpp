// 문제 출처: https://www.acmicpc.net/problem/1157

#include <iostream>
#include <cstring>

using namespace std;

int main(int argc, char const *argv[])
{
    int i = 0, j = 0, max = 0, maxvalue = 0;
    int count[26]={0, };
    char word[1000001];
    cin >> word;

    for (i=0; i<26; i++)
    {
        for(j=0; j<strlen(word); j++)
        {
            if (i + 97 == word[j] || i + 65 == word[j])
            {
                count[i]++;
            }
        }
        if(count[i] > max)
        {
            max = count[i];
            maxvalue = i;
        }
        else if(count[i] == max)
        {
            maxvalue = -2;
        }
    }
    
    maxvalue += 65;
    printf("%c", maxvalue);

    return 0;
}