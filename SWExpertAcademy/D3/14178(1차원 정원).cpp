// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AX_N3oSqcyUDFARi

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int testCase, T;

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        int numberOfFlowers, rangeOfSprinkler;
        int numberOfSprinklers;
        cin >> numberOfFlowers >> rangeOfSprinkler;

        rangeOfSprinkler = rangeOfSprinkler * 2 + 1;
        numberOfSprinklers = numberOfFlowers / rangeOfSprinkler;
        if(numberOfFlowers % rangeOfSprinkler != 0)
            numberOfSprinklers++;
        
        cout << "#" << testCase << " " << numberOfSprinklers << "\n";
    }

    return 0;
}