// https://www.acmicpc.net/problem/10757

#include <iostream>
#include <algorithm>

using namespace std;

int main(int argc, char const *argv[])
{
    string a, b;
    string answer;
    int carry = 0;
    int length = 0, i = 0;
   
    cin >> a >> b;

    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());


    // 아래 예외 처리를 위해 항상 a 길이가 짧게 만들어준다.
    if(a.length() > b.length())
        swap(a, b);

    length = b.length();
    int sum = 0;

    while(i < length)
    {

        // 백준에 질문을 통해 안 사실
        // length() 함수를 이용해 길이 비교로 예외처리시 통과 된다.
        // Null과 비교 방식의 예외처리가 먹히지 않았는데 아마 비교 연산으로 사용하면 안되는 듯
        if(i < a.length())
            sum = a[i] - '0';
        else
            sum = 0;

        sum += b[i] - '0' + carry;

        if(sum < 0)
            sum += '0';
        else if(sum > 9)
            carry = 1;
        else
            carry = 0;

        answer += (sum % 10) + '0';

        i++;
    }

    if(carry > 0)
        answer += '1';

    reverse(answer.begin(), answer.end());

    cout << answer;

    return 0;   
}