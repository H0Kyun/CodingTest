// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PttaaAZIDFAUq

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;

    cin>>T;

    for(test_case = 1; test_case <= T; ++test_case)
    {
        int left_time, left_min, right_time, right_min;
        int answer_time, answer_min;
        int carry = 0;
        
        cin >> left_time >> left_min >> right_time >> right_min;

        answer_min = left_min + right_min;

        if(answer_min >= 60)
        {
            answer_min -= 60;
            carry = 1;
        }

        answer_time = left_time + right_time + carry;
        if(answer_time > 12)
        {
            if(answer_time > 24)
                answer_time -= 24;
            else
                answer_time -= 12;
        }

        cout << "#" << test_case << " " << answer_time << " " << answer_min << "\n";

    }
    
    return 0;
}