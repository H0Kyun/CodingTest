// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QLGxKAzQDFAUq

#include<iostream>
#include<string>

using namespace std;
  
int main(int argc, char** argv)
{
    string alphabet;

    cin >> alphabet;

    for(int i = 0; i < static_cast<int>(alphabet.length()); i++)
    {
        cout << alphabet[i] - 64 << " ";
    }
    
    return 0;
}