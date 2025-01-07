#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr); 
    
    int N = 1;
    
    cin >> N;
    
    priority_queue<int, vector<int>, greater<int>> pq;
    
    for (int i = 0; i < N * N; ++i) {
        int num = 0;
        
        cin >> num;
        
        pq.push(num);
        
        if (pq.size() > N) {
            pq.pop();
        }
    }
    
    cout << pq.top();
    
    return 0;
}