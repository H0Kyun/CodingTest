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
    
    // 셋이 모두 같은 경우
    if (diceValues[0] == diceValues[1] && diceValues[1] == diceValues[2])
    {
        cout << 10000 + diceValues[0] * 1000;
    } 
    // 앞의 if 문에서 안 걸렸다는 것은 셋 중 하나가 다르거나 모두 다르다는 의미이므로
    // 둘이 같은 것이 있는지만 확인한다.
    else if (diceValues[0] == diceValues[1] || diceValues[1] == diceValues[2])
    {
        cout << 1000 + diceValues[1] * 100;
    }
    else if (diceValues[0] == diceValues[2])
    {
        cout << 1000 + diceValues[0] * 100;
    }
    // 모두 다른 경우
    else
    {
        cout << max * 100;
    }
    
    return 0;
}
