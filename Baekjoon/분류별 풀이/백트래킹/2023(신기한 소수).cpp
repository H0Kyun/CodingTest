// 문제 출처: https://www.acmicpc.net/problem/2023

#include<iostream>
#include<cmath>

using namespace std;

int checkPrime(int digit, int i)
{
    int prime;
    while(digit > 0)
    {
        prime = i / digit;
        int checknum = 2;
        while(checknum * checknum <= prime)
        {
            if(prime % checknum == 0) return digit;
            checknum++;
        }
        digit /= 10;
    }
    return 0;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N;
	cin >> N;

	int digit = (int)pow(10, N - 1);
	if(N == 1) cout << 2 << "\n";
    int start = 2 * digit + 1;
    for(int i = start; i < digit * 10; i += 2)
    {
        int prime = checkPrime(digit, i);
        if(prime == 0) cout << i << "\n";
        else i += prime - 2;
    }
	
    return 0;
}

