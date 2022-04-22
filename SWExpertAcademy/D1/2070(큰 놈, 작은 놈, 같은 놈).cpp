// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QQ6qqA40DFAUq

#include<iostream>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int test_case;
    int T;
    
    cin>>T;
    
    for(test_case = 1; test_case <= T; test_case++)
    {
        int left_side_hand = 0, right_side_hand = 0;
        char sign;
    
        cin >> left_side_hand >> right_side_hand;

        if(left_side_hand > right_side_hand)
            sign = '>';
        else if(left_side_hand < right_side_hand)
            sign = '<';
        else
            sign = '=';

        cout << "#" << test_case << " " << sign << "\n";
    }
    return 0;
}