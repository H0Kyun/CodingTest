// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PyTLqAf4DFAUq

#include<iostream>
#include<algorithm>
#include<string>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin>>T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
		string palindrome;
        
        cin >> palindrome;
        
        int half_length = int(palindrome.length()) / 2;
        int odd = 0;
        
        if(int(palindrome.length()) % 2 == 0)
            odd = 0;
        else
            odd = 1;
        
        string half_palidrome = palindrome.substr(half_length + odd);
        reverse(half_palidrome.begin(), half_palidrome.end());
                
        cout << "#" << test_case << " ";
        
        if(palindrome.substr(0, half_length) == half_palidrome)
           	cout << 1 << "\n";
        else
           cout << 0 << "\n";    
	}
	return 0;
}