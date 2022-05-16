// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV7GOPPaAeMDFAXB

#include<iostream>
#include<vector>

using namespace std;

vector<vector<int>>graph(21);
bool visited[21];
int numberOfVertex;
int numberOfLink;
int longestPathLegnth;

void reset()
{
    longestPathLegnth = 0;
    for(int i = 0; i < 21; i++)
    {
        graph[i].clear();
        visited[i] = false;
    }

    return;
}

void input()
{
    for(int i = 1; i <= numberOfLink; i++)
    {
        int vertex1, vertex2;

        cin >> vertex1 >> vertex2;

        graph[vertex1].push_back(vertex2);
        graph[vertex2].push_back(vertex1);
    }

    return;
}

void findPath(int index, int pathLength)
{
    if(longestPathLegnth < pathLength)
        longestPathLegnth = pathLength;

    for(int i = 0; i < graph[index].size(); i++)
    {
        int j = graph[index][i];
        if(!visited[j])
        {
            visited[j] = true;
            findPath(j, pathLength + 1);
            visited[j] = false;
        }
    }

    return;
}

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int testCase, T;

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        cin >> numberOfVertex >> numberOfLink;
		
        reset();
        input();

        for(int i = 1; i <= numberOfVertex; i++)
        {
            visited[i] = true;
            findPath(i, 1);
            visited[i] = false;
        }

        cout << "#" << testCase << " " << longestPathLegnth << endl;
    }

    return 0;
}
