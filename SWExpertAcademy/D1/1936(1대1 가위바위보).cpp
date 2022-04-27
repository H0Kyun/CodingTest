// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PjKXKALcDFAUq

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
	int A, B;
    char winner = 'A';
	
	cin >> A >> B;
	
	switch(A)
    {
        case 1:
            if(B == 2)
                winner = 'B';
            break;
        case 2:
            if(B == 3)
                winner = 'B';
            break;
        case 3:
            if(B == 1)
                winner = 'B';
            break;
    }

    cout << winner;
    
	return 0;
}