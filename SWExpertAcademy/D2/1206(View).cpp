// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV134DPqAA8CFAYh

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
	int test_case;
    
	for(test_case = 1; test_case <= 10; ++test_case)
	{
        int buildingCount;
        int buildingFloor[1000];
        int buildingWithViewCount = 0;
        
        cin >> buildingCount;
        
        for(int i = 0; i < buildingCount; i++)
            cin >> buildingFloor[i];
        
        for(int i = 2; i + 2 < buildingCount; i++)
        {
            if(buildingFloor[i] <= buildingFloor[i + 1] || buildingFloor[i] <= buildingFloor[i + 2])
            {
                if(buildingFloor[i + 1] < buildingFloor[i + 2])
                    i ++;
				continue;
            }
            
            if(buildingFloor[i] <= buildingFloor[i - 1] || buildingFloor[i] <= buildingFloor[i - 2])
            {
                if(buildingFloor[i - 1] > buildingFloor[i + 1])
                    i ++;
				continue;
            }

            int array[4] = {buildingFloor[i - 2], buildingFloor[i - 1], buildingFloor[i + 1], buildingFloor[i + 2]};
            int maxFloor = array[0];

            for(int j = 1; j < 4; j++)
            {
                if(array[j] > maxFloor)
                    maxFloor = array[j];
            }

            buildingWithViewCount += buildingFloor[i] - maxFloor;
            i+=2;
        }
        
        cout << "#" << test_case << " " << buildingWithViewCount << "\n";
	}

	return 0;
}