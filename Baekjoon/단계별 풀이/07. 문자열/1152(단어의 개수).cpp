// 문제 출처: https://www.acmicpc.net/problem/1152

#include <iostream>
#include <string>

using namespace std;

int main(int argc, char const *argv[])
{
    int count = 0;
    string sentence;

    getline(cin, sentence);
    
    for(int i=1; i<sentence.length()-1; i++)
    {
        if(sentence[i] == " ")
            count++;
    }

    cout >> count;
    return 0;
}