#include <iostream>

using namespace std;

int main ()
{
    int N = 0, M = 0;
    cin >> N >> M;
    
    int *array = new int[N];
    
    while(--M >= 0)
    {
        int i = 0, j = 0, k = 0;
        cin >> i >> j >> k;
        
        i -= 2;
        --j;
        
        while(++i <= j)
        {
           array[i] = k; 
        }
    }
    
    for(int i = 0; i < N; ++i)
    {
        cout << array[i] << " ";
    }
    
    delete[] array;
    
    return 0;
}