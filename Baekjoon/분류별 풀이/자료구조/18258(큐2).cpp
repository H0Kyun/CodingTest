// 문제 출처: https://www.acmicpc.net/problem/18258

#include<iostream>
#include<queue>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	queue<int> q;
	
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
            q.push(data);
        } 
        else if(command.compare("pop") == 0)
        {
            if(!q.empty())
            {
                cout << q.front();
                q.pop();
            }
            else cout << -1;
            cout << "\n";
        }
        else if(command.compare("size") == 0)
        {
            cout << q.size() << "\n";
        }
        else if(command.compare("empty") == 0)
        {
            if(q.empty()) cout << 1;
            else cout << 0;
            cout << "\n";
        }
        else if(command.compare("front") == 0)
        {
            if(!q.empty())
            {
                cout << q.front();
            }
            else cout << -1;
            cout << "\n";
        }
        else if(command.compare("back") == 0)
        {
            if(!q.empty())
            {
                cout << q.back();
            }
            else cout << -1;
            cout << "\n";
        }
    }
    
	return 0;
}
