// 문제 출처: https://www.acmicpc.net/problem/2941

#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[])
{
    string word;
    vector<string> croatian = {"c=", "c-", "d-", "lj", "nj", "s=", "z="};
    string croatian_dz = "dz=";
    int count = 0;
    
    cin >> word;
    for(int i=0; i<word.length(); i++)
    {
        count++;
        for(int j=0; j<croatian.size(); j++)
        {
            if(word.substr(i, 2) == croatian[j])
                i++;
        }
        if(word.substr(i, 3) == croatian_dz)
            i+=2;
    }
    
    cout << count;
    
    return 0;
}
