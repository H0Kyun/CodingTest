// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5QLkdKAz4DFAUq

#include<iostream>
#include<string>

using namespace std;
  
int main(int argc, char** argv)
{
    int test_case;
	int T;
	
	cin >> T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
        string YMD;
        int month, day;
        bool valid = false;

        cin >> YMD;

        month = (YMD[4] - '0') * 10 + (YMD[5] - '0');
        day = (YMD[6] - '0') * 10 + (YMD[7] - '0');

        if(month < 1 || month > 12)
        {
            cout << "#" << test_case << " " << -1 << "\n";
            continue;
        }

        switch(month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(1 <= day && day <= 31)
                    valid = true;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if(1 <= day && day <= 30)
                    valid = true;
                break;
            case 2:
                if(1 <= day && day <= 28)
                    valid = true;
                break;
        }

        if(valid)
            cout << "#" << test_case << " " << YMD.substr(0, 4) << "/" << YMD.substr(4, 2) << "/" << YMD.substr(6, 2) << "\n";
        else
            cout << "#" << test_case << " " << -1 << "\n";
	}
    
    return 0;
}