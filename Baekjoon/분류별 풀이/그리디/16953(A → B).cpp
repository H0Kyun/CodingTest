// 문제 출처: https://www.acmicpc.net/problem/16953

#include <iostream>
#include <queue>

using namespace std;

int bfs(int A, int B)
{
    queue<int> q;
    q.push(A);
    int depth = 1;
    while(!q.empty())
    {
        int size = q.size();
        while(--size >= 0)
        {
            int cur = q.front();
            q.pop();
            if(cur > 500000000) continue;
            int times = cur * 2;
            if(times == B) return depth + 1;
            if(times < B) q.push(times);

            if(cur > 100000000) continue;
            int appendOne = cur * 10 + 1;
            if(appendOne == B) return depth + 1;
            if(appendOne < B) q.push(appendOne);
        }
        depth++;
    }
    
    return -1;
}

int main()
{
    int A, B;
    cin >> A >> B;
		
    cout << bfs(A, B);
}
	