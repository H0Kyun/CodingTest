// https://www.acmicpc.net/problem/2775

#include <iostream>

using namespace std;

int floorPeople(int f, int n);

int main(int argc, char const *argv[])
{
    int testCase = 0;
    int floor = 0, number = 0; 

    cin >> testCase;

    int answer[testCase];

    for (int i = 0; i < testCase; i++)
    {
        cin >> floor;
        cin >> number;

        answer[i] = floorPeople(floor, number);
    }

    for (int i = 0; i < testCase; i++)
        cout << answer[i] << "\n";

    
}

int floorPeople(int f, int n)
{
    int sum = 0;

    if(f == 0)
        return n;

    for(int i = n; i >= 1; i--)
        sum += floorPeople(f-1, i);

    return sum;
}