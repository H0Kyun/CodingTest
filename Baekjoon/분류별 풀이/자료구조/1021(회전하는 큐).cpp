#include<iostream>
#include<deque>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M;
	cin >> N >> M;
	deque<int> dequeue(N);
	deque<int> mqueue(M);

	for (int i = 1; i <= N; i++)
		dequeue[i - 1] = i;

	for (int i = 0; i < M; i++)
		cin >> mqueue[i];

	int count = 0;
	while (!mqueue.empty())
	{
		int mFirst = mqueue.front();
		int findIdx = 0;
		for (int i = 0; i < dequeue.size(); i++)
		{
			if (dequeue[i] == mFirst)
			{
				findIdx = i;
				break;
			}
		}

		if (findIdx > (dequeue.size() - findIdx))
		{
			while (dequeue.front() != mFirst)
			{
				count++;
				dequeue.push_front(dequeue.back());
				dequeue.pop_back();
			}
		}
		else
		{
			while (dequeue.front() != mFirst)
			{
				count++;
				dequeue.push_back(dequeue.front());
				dequeue.pop_front();
			}
		}

		mqueue.pop_front();
		dequeue.pop_front();
	}

	cout << count;
	return 0;
}
