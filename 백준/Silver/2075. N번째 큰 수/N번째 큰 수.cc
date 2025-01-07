#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); 
    
    int N;
    
    cin >> N;
    
    priority_queue<int, vector<int>, greater<int>> pq;
    
    for (int i = 0; i < N; ++i) {
        int num = 0;
        
        cin >> num;
        
        pq.push(num);
    }
    
    for (int i = N; i < N * N; ++i) {
        int num = 0;
        
        cin >> num;
        
        if (pq.top() < num) {
            pq.pop();
            pq.push(num);
        }
    }
    
    cout << pq.top();
    
    return 0;
}