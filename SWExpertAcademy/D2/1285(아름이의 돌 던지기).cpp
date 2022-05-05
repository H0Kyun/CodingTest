// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18-stqI8oCFAZN

#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        int number;
        
        cin >> number;
        
        vector<int>numbers(number, 0);
        int min_distance = 100001;
        
        for(int i = 0; i < number; i++)
        {
            int distance;
            cin >> distance;
            
            if(distance < 0)
                distance *= -1;
            
            if(min_distance > distance)
                min_distance = distance;
            
            numbers[i] = distance;
        }
        
        int count = 0;
        
        for(int i = 0; i < number; i++)
        {
            if (numbers[i] == min_distance)
                count++;
        }
        
        cout << "#" << test_case << " " << min_distance << " " << count << "\n";
	}
	return 0;
}