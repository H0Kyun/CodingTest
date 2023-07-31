#include <iostream>

using namespace std;

int main()
{
    int N = 0, M = 0;
    cin >> N >> M;
    
    int *array = new int[N];
    
    for(int i = 0; i < N; ++i)
    {
        array[i] = i + 1;
    }
    
    for(int k = 0; k < M; ++k)
    {
        int i = 0, j = 0;
        cin >> i >> j;
        int count = (j - i + 1) / 2;
        --i;
        --j;
        while (--count >= 0)
        {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            ++i;
            --j;
        }
    }
    
    for(int i = 0; i < N; ++i)
    {
        cout << array[i] << " ";
    }
    
    delete[] array;
    return 0;
}