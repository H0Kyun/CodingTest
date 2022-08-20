// 문제 출처: https://www.acmicpc.net/problem/3048

#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios::sync_with_stdio(false);
	cin.tie(NULL);
    
    int N1, N2, T;
    cin >> N1 >> N2;
    int totalLength = N1 + N2;
    vector<pair<char, int>> ants(totalLength);
    
    for(int i = N1 - 1; i >= 0; i--)
    {
        cin >> ants[i].first;
    }

    for(int i = N1; i < totalLength; i++)
    {
        cin >> ants[i].first;
        ants[i].second = 1;
    }

    cin >> T;
    for(int i = 0; i < T; i++)
    {
        for(int j = 0; j < totalLength - 1; j++)
        {
            if(ants[j].second == 0 && ants[j + 1].second == 1)
            {
                pair<char, int> temp = ants[j];
                ants[j] = ants[j + 1];
                ants[j + 1] = temp;
                j++;
            }
        }
    }

    for(pair<char, int> ant : ants)
    {
        cout << ant.first;
    }

    return 0;
}