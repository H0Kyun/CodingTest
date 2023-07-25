#include <iostream>

using namespace std;

int main () {
    int X = 0;
    int N = 0;
    
    cin >> X;
    cin >> N;
    
    int totalPrice = 0;
    
    for(int i = 0; i < N; i++)
    {
        int price = 0, numberOfItem = 0;
        cin >> price >> numberOfItem;
        totalPrice += price * numberOfItem;
    }
    
    cout << (totalPrice == X ? "Yes" : "No");
    
    return 0;
}