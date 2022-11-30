// 문제 출처: https://school.programmers.co.kr/learn/courses/30/lessons/42626

#include <string>
#include <vector>
#include <queue>

using namespace std;

int solution(vector<int> scoville, int K) {
    int answer = 0;

    priority_queue<int, vector<int>, greater<>> pq; // 최소 힙

    // 모든 수를 최소 힙에 넣는다.
    for(int i = 0; i < scoville.size(); i++) 
    {
        pq.push(scoville[i]);
    }
    
    // 제일 작은 수가 K보다 작고 힙의 크기가 1보다 클 때까지 반복
    while(pq.top() < K && pq.size() > 1)
    {
        int first = pq.top(); // 제일 안 매운 음식 지수
        pq.pop();
        int second = pq.top(); // 두 번째로 안 매운 음식 지수
        pq.pop();
        int new_scoville = first + second * 2; // 섞은 음식 지수
        pq.push(new_scoville);
        answer++;
    }
    
    // 최소힙에 남은 수가 K 보다 작으면 -1 리턴
    // 이 때 사이즈는 1이다.
    if(pq.top() < K)
    {
        answer = -1;
    }
    
    return answer;
}