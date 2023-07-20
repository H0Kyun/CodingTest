#include <iostream>

using namespace std;

int main()
{
    int A, B, C;
    cin >> A >> B;
    cin >> C;
    
    int hour = (A + (C / 60 + (B + C % 60) / 60)) % 24;
    int min = (B + C % 60) % 60;
    
    cout << hour << " " << min;
    return 0;
}