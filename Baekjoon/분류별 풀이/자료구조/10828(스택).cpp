// 문제 출처: https://www.acmicpc.net/problem/10828

#include<iostream>
#include<stack>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	stack<int> s;
	
    int numberOfCommand;
    cin >> numberOfCommand;
	for (int i = 0; i < numberOfCommand; i++)
	{
        string command;
        cin >> command;
        if(command.compare("push") == 0)
        {
            int data;
            cin >> data;
            s.push(data);
        } 
        else if(command.compare("pop") == 0)
        {
            if(!s.empty())
            {
                cout << s.top();
                s.pop();
            }
            else cout << -1;
            cout << "\n";
        }
        else if(command.compare("size") == 0)
        {
            cout << s.size() << "\n";
        }
        else if(command.compare("empty") == 0)
        {
            if(s.empty()) cout << 1;
            else cout << 0;
            cout << "\n";
        }
        else if(command.compare("top") == 0)
        {
            if(!s.empty())
            {
                cout << s.top();
            }
            else cout << -1;
            cout << "\n";
        }
    }
    
	return 0;
}
