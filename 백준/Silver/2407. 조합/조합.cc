#include<iostream>

using namespace std;

int main() {
    unsigned int n = 0;
    unsigned int m = 0;
    __uint128_t result = 1;

    cin >> n >> m;

    for (int i = 0; i < m; ++i) {
        result *= n - i;
        result /= i + 1;
    }

    
    string number = "0123456789";
    string resultStr = "";
    do
    {
        resultStr = number[ result % 10 ] + resultStr;
        result /= 10;
    } while ( result != 0 );

    cout << resultStr << endl;

    return 0;
}