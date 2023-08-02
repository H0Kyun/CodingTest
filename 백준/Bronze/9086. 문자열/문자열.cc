#include <iostream>

using namespace std;

int main()
{
    int T = 0;
    cin >> T;
    
    for(int i = 0; i < T; ++i)
    {
        string str;
        cin >> str;
        cout << str.front() << str.back() << "\n";
    }
    
    return 0;
}