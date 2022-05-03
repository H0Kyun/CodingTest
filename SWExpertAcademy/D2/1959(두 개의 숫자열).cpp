// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PpoFaAS4DFAUq

#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;

	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        int a_length, b_length; 
		int long_length, short_length;
      
        cin >> a_length >> b_length;
        
        vector<int>long_array(a_length, 0);
        vector<int>short_array(b_length, 0);
        
        for(int i = 0; i < a_length; i++)
            cin >> long_array[i];
        
         for(int i = 0; i < b_length; i++)
            cin >> short_array[i];
        
        if(a_length >= b_length)
        {
			long_length = a_length;
            short_length = b_length;
        }
        else
        {
            long_length = b_length;
            short_length = a_length;
            long_array.swap(short_array);
        }
        
        int max_sum = 0;
        
       for(int i = 0; i + short_length <= long_length; i++)
       {
           int sum = 0;
           for(int j = i; j < i + short_length; j++)
           {
               sum += long_array[j] * short_array[j - i];
           }
           
           if(max_sum <= sum)
               max_sum = sum;
       }
        
        
        cout << "#" << test_case << " " << max_sum << endl;
	}
	return 0;
}