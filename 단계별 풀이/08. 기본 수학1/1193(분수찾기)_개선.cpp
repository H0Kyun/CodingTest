// 문제 출처: https://www.acmicpc.net/problem/1193

#include <iostream>

using namespace std;

int main()
{
    int X = 0;
    int i = 0;
    int k = 1;
    
    cin >> X;
    
    while(X - k >= 0)
    {
        i++;
        k+=i;
    }
    
    X = X-(k-i);
    
    cout << i << "i\n";
    cout << X << "X\n";
        
    if(i%2 == 0)
        cout << 1+X << "/" << i-X;
    else
        cout << i-X << "/" << 1+X;


    return 0;
}