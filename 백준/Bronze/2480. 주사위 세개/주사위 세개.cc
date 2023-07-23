#include <iostream>

using namespace std;

int main()
{
    int diceValues[3] = {0, 0, 0};
    int max = 0;
    
    for(int i = 0; i < 3; i++)
    {    
        cin >> diceValues[i];
        
        if(max < diceValues[i])
        {
            max = diceValues[i];
        }
    }
    
    if (diceValues[0] == diceValues[1] && diceValues[1] == diceValues[2])
    {
        cout << 10000 + diceValues[0] * 1000;
    } 
    else if (diceValues[0] != diceValues[1] && diceValues[1] == diceValues[2])
    {
        cout << 1000 + diceValues[1] * 100;
    }
    else if ((diceValues[0] == diceValues[1] && diceValues[1] != diceValues[2])
        ||(diceValues[0] != diceValues[1] && diceValues[0] == diceValues[2]))
    {
        cout << 1000 + diceValues[0] * 100;
    }
    else
    {
        cout << max * 100;
    }
    
    return 0;
}