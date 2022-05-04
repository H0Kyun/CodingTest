// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PrmyKAWEDFAUq

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	cin >> T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
		int length;
        
        cin >> length;
        
        vector<int> numbers(length, 0);
        
        for(int i = 0; i < length; i++)
           cin >> numbers[i];

        sort(numbers.begin(), numbers.end());
        
        cout << "#" << test_case << " ";
        for(int i = 0; i < length; i++)
            cout << numbers[i] << " ";
        cout << endl;
	}
	return 0;
}