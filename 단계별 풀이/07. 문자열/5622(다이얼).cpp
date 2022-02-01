// 문제 출처: https://www.acmicpc.net/problem/5622

#include <iostream>
#include <string.h>

using namespace std;

int main(int argc, char const *argv[])
{
    int second = 0;
    char word[16];
    
    cin >> word;
    
    for(int i=0; i<strlen(word); i++)
    {
        switch(word[i] - 65)
        {
            case 0: case 1: case 2:
                second+=3;
                break;
            case 3: case 4: case 5:
                second+=4;
                break;
            case 6: case 7: case 8:
                second+=5;
                break;
            case 9: case 10: case 11:
                second+=6;
                break;
            case 12: case 13: case 14:
                second+=7;
                break;
            case 15: case 16: case 17: case 18:
                second+=8;
                break;
            case 19: case 20: case 21:
                second+=9;
                break;
            case 22: case 23: case 24: case 25:
                second+=10;
                break;
        }
    }
    
    cout << second;
    
    return 0;
}
