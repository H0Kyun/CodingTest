// 문제 출처: https://www.acmicpc.net/problem/2493

#include<iostream>
#include<stack>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int numberOfTower;
	cin >> numberOfTower;
	stack<int> Stack;
    stack<int> index;
	
    int input;
    cin >> input;
    Stack.push(input);

    cout << "0 ";
    index.push(0); index.push(1);
    
    for(int i = 2; i <= numberOfTower; i++)
    {
        int towerHeight;
        cin >> towerHeight;
        while(!Stack.empty())
        {
            if(Stack.top() < towerHeight)
            {
                Stack.pop();
                index.pop();
            } else break;
        }
        cout << index.top() << " ";
        Stack.push(towerHeight);
        index.push(i);
    }
	return 0;
}
