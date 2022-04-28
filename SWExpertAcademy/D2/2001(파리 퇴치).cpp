// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq

#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
    int test_case;

    cin >> test_case;

    for(int i = 1; i <= test_case; i++)
    {
        int zone_area, flyflap_area;
        
        cin >> zone_area >> flyflap_area;
		
        int number_of_flies;
        
        vector<vector<int>> zone(zone_area); //2차원 vector 컨테이너

        for(int j = 0; j < zone_area; j++)
        {
            zone[j].resize(zone_area);
            for(int k = 0; k < zone_area; k++)
            {
                cin >> zone[j][k];
            }
        }
        
        int max_number_of_flies_to_kill = 0;
        
        for(int j = 0; j + flyflap_area <= zone_area; j++) //지옥의 4중 for문
        {
            for(int k = 0; k + flyflap_area <= zone_area; k++)
            {
                int number_of_flies_to_kill = 0;
                for(int p = j; p < j + flyflap_area; p++)
                {
                    for(int q = k; q < k + flyflap_area; q++)
                    {
                        number_of_flies_to_kill += zone[p][q];
                    }
                }
                if(max_number_of_flies_to_kill <= number_of_flies_to_kill)
                {
                            max_number_of_flies_to_kill = number_of_flies_to_kill;
                }
            }
        }
		
        cout << "#" << i << " " << max_number_of_flies_to_kill << "\n";    
    }

    return 0;
}