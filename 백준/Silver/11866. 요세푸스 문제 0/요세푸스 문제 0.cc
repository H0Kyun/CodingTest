#include<iostream>
#include<queue>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int length, index;
	cin >> length >> index;
	
    queue<int> q;
	for (int i = 1; i <= length; i++)
		q.push(i);

	cout << "<";
	while (q.size() > 1)
	{
		for(int i = 0; i < index - 1; i++)
        {
            q.push(q.front());
            q.pop();
        }
        cout << q.front() << ", ";
        q.pop();
	}

	cout << q.front() << ">";

	return 0;
}