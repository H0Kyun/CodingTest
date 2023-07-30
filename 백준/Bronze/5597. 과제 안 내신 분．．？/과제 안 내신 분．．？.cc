#include <iostream>

using namespace std;

int main()
{
    bool checked[30] = {false, };
    for(int i = 0; i < 28; ++i)
    {
        int n = 0;
        cin >> n;
        checked[--n] = true; 
    }
    
    for(int i = 0; i < 30; ++i)
    {
        if(!checked[i])
        {
            cout << (i + 1) << "\n";
        }
    }
    
    return 0;
}