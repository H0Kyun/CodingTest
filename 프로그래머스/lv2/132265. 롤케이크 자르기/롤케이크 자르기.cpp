#include <vector>
#include <set>

using namespace std;

int solution(vector<int> topping) {
    int topping_count[10001] = {0, };
    int topping_type = 0;
    for(int i : topping)
    {
        if(topping_count[i] == 0) topping_type++;
        topping_count[i]++;
    }
    int answer = 0; 
    set<int> end;
    for(int i : topping)
    {
        topping_count[i]--;
        end.insert(i);
        if(topping_count[i] == 0) topping_type--;
        if(end.size() == topping_type) answer++;
        if(end.size() > topping_type) break;
        
    }
    
    return answer;
}