// https://www.acmicpc.net/problem/2869

#include <iostream>

using namespace std;

int main(int argc, char const *argv[])
{
    int A = 0, B = 0, V = 0;
    int day = 1;

    cin >> A >> B >> V;

    V -= A;

    if(V == 0)
    {
        day = 1;
    }
    else if(V + B < A)
    {
        day++;
    }
    else
    {
        day += V / (A - B);

        if(V % (A - B) != 0)
            day++;
    }

    cout << day;

    
    return 0;
}