// 문제 출처: https://www.acmicpc.net/problem/1193

#include <iostream>

using namespace std;

int main()
{
    int plus[2][2] = {{-1, 1}, {1, -1}};
    int faction[2] = {1, 1};
    int X = 0;
    int k = 1;
    bool b = true;
    
    cin >> X;
    
    
    if(X == 2)
    {
        faction[0] = 1;
        faction[1] = 2;
    }
    
    if(X >= 3)
    {
        faction[0] = 2;
        faction[1] = 1;
    }
    
    for(int i=3; i<X; i++)
    {
        if(faction[0] == 1 && faction[1] != 1 && b)
        {
            faction[1]++;
            k = 1;
            b = false;
        }
        else if(faction[1] == 1 && faction[0] != 1 && b)
        {
            faction[0]++;
            k = 0;
            b = false;
        }
        else
        {
            faction[0] += plus[k][0];
            faction[1] += plus[k][1];
            b = true;
        }
        
        cout << i << "\n";
        cout << faction[0] << "/" << faction[1] << "\n";
    }

    cout << "\n" << faction[0] << "/" << faction[1];

    return 0;
}