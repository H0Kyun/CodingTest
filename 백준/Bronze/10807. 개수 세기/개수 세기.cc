#include <iostream>

using namespace std;

int main()
{
    int N = 0;
    cin >> N;
    
    int *array = new int[N];
    for (int i = 0; i < N; ++i)
    {
        cin >> array[i];
    }
    
    int count = 0;
    int v = 0;
    cin >> v;
    
    for (int i = 0; i < N; ++i)
    {
        if (v == array[i])
        {
            ++count;
        }
    }
    
    cout << count;
    
    delete[] array;
    
    return 0;
}