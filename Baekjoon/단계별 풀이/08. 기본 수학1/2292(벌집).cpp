// 문제 출처: https://www.acmicpc.net/problem/2292

#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    int N = 0;
    int sum = 0, path = 0;

    cin >> N;
    
    while(true)
    {
        sum = sum + path * 6;
        if(N <= 1 + sum)
        {
            path++;
            break;
        }
        path++;
    }
        
    cout << path << "\n";
    
    return 0;
}