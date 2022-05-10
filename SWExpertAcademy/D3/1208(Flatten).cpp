// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV139KOaABgCFAYh

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for(int testCase = 1; testCase <= 10; testCase++)
    {
        int dumpCount;

        cin >> dumpCount;

        int boxStorage[100];
        int maxValue = 0;
        int minValue = 100;
        for(int i = 0; i < 100; i++)
        {
            int numberOfBox;

            cin >> numberOfBox;

            boxStorage[i] = numberOfBox;

            if(numberOfBox >= maxValue)
                maxValue = numberOfBox;

            if(numberOfBox <= minValue)
                minValue = numberOfBox;
        }

        while(dumpCount >= 0)
        {
            int maxValueIndex = -1;
            int minValueIndex = -1;
            for(int i = 0; i < 100; i++)
            {
                if(maxValue == boxStorage[i])
                {
                    maxValueIndex = i;
                    break;
                }
            }

            for(int i = 0; i < 100; i++)
            {
                if(minValue == boxStorage[i])
                {
                    minValueIndex = i;
                    break;
                }
            }

            if(maxValueIndex != -1 && minValueIndex != -1)
            {
                boxStorage[maxValueIndex]--;
                boxStorage[minValueIndex]++;
                dumpCount--;
            }
            else if(maxValueIndex == -1 && minValueIndex != -1)
            {
                maxValue--;
            }
            else if(maxValueIndex != -1 && minValueIndex == -1)
            {
                minValue++;
            }
            else if(maxValueIndex == -1 && minValueIndex == -1)
            {
                if(maxValue - minValue <= 1)
                    break;
                minValue++;
                maxValue--;
            }
        }

		cout << "#" << testCase << " " << maxValue - minValue << endl;
    }
    return 0;
}

