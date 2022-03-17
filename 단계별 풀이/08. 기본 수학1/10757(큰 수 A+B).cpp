// https://www.acmicpc.net/problem/10757

//코드 출처 기존 내가 만들었던 코드(10757(큰 수 A+B)_실패)는 16번째 계산에서 계속 값이 이상하게 나왔다
// 해결 못해서 아래 사이트를찾아 참고하여 만듦
//https://suppplier.github.io/posts/BOJ_10757/

#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[])
{
    string a, b;
    string answer;
    int carry = 0;
   
    cin >> a >> b;

    int alength = a.length();
    int blength = b.length();

    int sum = 0;

    while(alength > 0 || blength > 0)
    {
        int A = 0, B = 0;

        if(alength > 0)
            A = a[--alength] - '0';

         if(blength > 0)
            B = b[--blength] - '0';

        int sum = A + B + carry;

        carry = sum / 10;
        sum %= 10;

        answer += (sum + '0');
    }

    if(carry > 0)
        answer += '1';

    reverse(answer.begin(), answer.end());

    cout << answer;

    return 0;   
}