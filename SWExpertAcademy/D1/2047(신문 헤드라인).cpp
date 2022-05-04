// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QKsLaAy0DFAUq

#include<iostream>
#include<string>

using namespace std;
  
int main(int argc, char** argv)
{
    string head_line;

    cin >> head_line;

    for(int i = 0; i < static_cast<int>(head_line.length()); i++)
    {
        if(97 <= head_line[i] && head_line[i] <= 122)
            cout << static_cast<char>(head_line[i] - 32);
        else
            cout << head_line[i];
    }
    
    return 0;
}