// 문제 출처: https://www.acmicpc.net/problem/1712

#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    int fixedcost = 0, variablecost = 0, laptopprice = 0;

    cin >> fixedcost >> variablecost >> laptopprice;
    
    if(laptopprice <= variablecost)
    {
        cout << -1 << "\n";
        return 0;
    }

    int breakevenpoint = fixedcost / (laptopprice - variablecost) + 1;

    cout << breakevenpoint;
    
    return 0;
}