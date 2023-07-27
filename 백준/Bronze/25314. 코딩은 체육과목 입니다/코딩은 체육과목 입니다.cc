#include <iostream>

using namespace std;

int main()
{
    int N = 0;
    
    cin >> N;
    
    string dataType = "int";
    for(int i = 0; i < N / 4; i++)
    {
        dataType = "long " + dataType;
    }
    
    if (N % 4 > 0)
    {
        dataType = "long " + dataType;
    }
    
    cout << dataType;
    
    return 0;
}