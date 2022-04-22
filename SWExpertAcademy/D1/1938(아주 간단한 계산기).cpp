//문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PjsYKAMIDFAUq

#include<iostream>
 
using namespace std;
 
int main(int argc, char** argv)
{
    int left_hand_side = 0, right_hand_side = 0;
     
    cin >> left_hand_side >> right_hand_side;
     
    cout << left_hand_side + right_hand_side << "\n"
        << left_hand_side - right_hand_side << "\n"
        << left_hand_side * right_hand_side << "\n"
        << left_hand_side / right_hand_side << "\n";
    return 0;
}