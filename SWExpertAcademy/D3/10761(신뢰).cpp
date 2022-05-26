// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXSVc1TqEAYDFAQT

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
        int numberOfCommands;
        int clearTime = 0;
        int oPosition = 1, bPosition = 1;
        int timeOCanMove = 0, timeBCanMove = 0;

        cin >> numberOfCommands;

        for(int i = 0; i < numberOfCommands; i++)
        {
            char robot;
            int buttonNumber;

            cin >> robot >> buttonNumber;

            if(robot == 'O')
            {
                int movingTime = abs(buttonNumber - oPosition);
                if(timeOCanMove >= movingTime)
                {
                    timeBCanMove++;
                    clearTime++;
                }
                else
                {
                    int totalActTime = buttonNumber > oPosition 
                    ? buttonNumber - (oPosition + timeOCanMove) + 1 : (oPosition - timeOCanMove) - buttonNumber + 1;
                    
                    clearTime += totalActTime;
                    timeBCanMove +=totalActTime;
                }
             	timeOCanMove = 0;
                oPosition = buttonNumber;
            }

            if(robot == 'B')
            {
                int movingTime = abs(buttonNumber - bPosition);
                if(timeBCanMove >= movingTime)
                {
                    timeOCanMove++;
                    clearTime++;
                }
                else
                {
                    int totalActTime = buttonNumber > bPosition 
                    ? buttonNumber - (bPosition + timeBCanMove) + 1 : (bPosition - timeBCanMove) - buttonNumber + 1;
                    
                    clearTime += totalActTime;
                    timeOCanMove +=totalActTime;
                }
                timeBCanMove = 0;
                bPosition = buttonNumber;  
            }
        }
        
        cout << "#" << testCase << " " << clearTime << "\n";
    }

    return 0;
}