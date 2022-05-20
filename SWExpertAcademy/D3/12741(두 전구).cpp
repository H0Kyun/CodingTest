// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXuUo_Tqs9kDFARa

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int testCase, T;

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        int xOnTime, xOffTime, yOnTime, yOffTime;
        int overlappingTime = 0;

        cin >> xOnTime >> xOffTime >> yOnTime >> yOffTime;

        if(xOnTime <= yOnTime)
        {
            if(xOffTime <= yOffTime)
            {
                if(yOnTime < xOffTime)
                    overlappingTime = xOffTime - yOnTime;
            }
            else
            {
                overlappingTime = yOffTime - yOnTime;
            }
        }
        else
        {
            if(yOffTime <= xOffTime)
            {
                if(xOnTime < yOffTime)
                    overlappingTime = yOffTime - xOnTime;
            }
            else
            {
                overlappingTime = xOffTime - xOnTime;
            }
        }
        
        cout << "#" << testCase << " " << overlappingTime << "\n";
    }

    return 0;
}