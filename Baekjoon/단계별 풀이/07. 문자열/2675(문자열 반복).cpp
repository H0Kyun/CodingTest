// 문제 출처: https://www.acmicpc.net/problem/2675

#include <iostream>
#include <cstring>

using namespace std;

int main(int argc, char const *argv[])
{
    int casenum = 0, i = 0, j = 0, t = 0;
    
    scanf("%d", &casenum);


    /* 
    char test[casenum][21];
    int count[casenum];
    
    for(i=0; i<casenum; i++)
    {
        scanf("%d %s", &count[i], test[i]);
    }
    
    for(i=0; i<casenum; i++)
    {
        for(t=0; t<strlen(test[i]); t++)
        {
            for(j=0; j<count[i]; j++)
            {
                printf("%c", test[i][t]);   
            }
        }
        printf("\n");
    }
    모든 입력을 먼저 받고 출력하는 줄 알고 위처럼 작성했지만
    그럴 필요는 없었다.
    */

    // 아래와 같이 작성해도 정답이었다
    char test[21];
    int count;

    for(i=0; i<casenum; i++)
    {
        scanf("%d %s", &count, test);
        for(t=0; t<strlen(test); t++)
        {
            for(j=0; j<count; j++)
            {
                printf("%c", test[t]);   
            }
        }
        printf("\n"); // 출력 예에 줄바꿈이 있으면 꼭 작성하자
    }

    return 0;
}
