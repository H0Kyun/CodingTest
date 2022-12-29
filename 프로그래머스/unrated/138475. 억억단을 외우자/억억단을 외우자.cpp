#include <vector>
#include <iostream>

using namespace std;
/*
 * 초기에 약수 구하는 공식을 아래와 같이 작성했지만
 * 아래 공식을 이용하면 1~500만까지 연산했을 때 74억 가까운 연산량을 보여
 * 시간 초과가 발생했다.
 */
int get_divisor_count(int n)
{
    int count = 0;
    for(int i = 1; i * i <= n; i++)
        {
            if(n % i == 0)
            {
                count++;
                if(i * i < n)
                    count++;   
            }
        }
    return count + 2;
}

vector<int> solution(int e, vector<int> starts) {
    vector<int> answer(starts.size());

    //int divisor_count[2][e + 1];
    vector<int> divisor_count(e + 1);
    vector<int> divisor_count2(e + 1);
    for(int i = 1; i <= e; i++)
        for(int j = 1; j <= (e / i); j++)
            divisor_count[i * j]++;
    
    
    //divisor_count[1][e] = e;
    divisor_count2[e] = e;
    for(int i = e - 1; i >= 1; i--)
    {
        if(divisor_count[divisor_count2[i + 1]] <= divisor_count[i])
            divisor_count2[i] = i;
        else
            divisor_count2[i] = divisor_count2[i + 1];
    }
    
    for(int i = 0; i < starts.size(); i++)
    {
        answer[i] = divisor_count2[starts[i]];
    }

    return answer;
}