// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV18_yw6I9MCFAZN

#include<iostream>
#include<string>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	cin>>T;
    

	for(test_case = 1; test_case <= T; ++test_case)
	{
        string number;
        
        cin >> number;

        bool check_number[10] = {false, };  
        int count_number = 0, count = 1;
        
		string compare = number;
        while(true)
        {
            for(int i = 0; i < compare.length(); i++)
            {
                if(!check_number[compare[i] - '0'])
                {
                    check_number[compare[i] - '0'] = true;
                    count_number++;
                }
            }
			
            if(count_number == 10)
                break;
            
            count++;
            int temp = stoi(number);
            temp *= count;
            compare = to_string(temp);
        }

        cout << "#" << test_case << " " << compare << endl;
	}
	return 0;
}