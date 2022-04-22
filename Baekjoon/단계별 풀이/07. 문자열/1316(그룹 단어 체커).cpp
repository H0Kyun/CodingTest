// 문제 출처: https://www.acmicpc.net/problem/1316

#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    string word;
    int alphabet[26];
    int num = 0, count = 0;
    int i = 0, j = 0, k = 0;
    
    cin >> num;
    
    count = num;
    
    for(i=0; i<num; i++)
    {
        cin >> word;
        
        for(j=0; j<26; j++)
            alphabet[j] = -1;
            
        for(j=0; j<word.length(); j++)
        {
            for(k=0; k<26; k++)
            {
                if(word[j] - 97 == k)
                {
                    if(alphabet[k] == -1 || j - alphabet[k] <= 1)
                    {
                        alphabet[k] = j;
                    }
                    else
                    {
                        count--;
                        break;
                    }
                }
            }
            if(k!=26)
                break;
        }
    }
    
    cout << count;
    
    return 0;
}