#include<iostream>
#include<queue>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for(int testCase = 1; testCase <= 10; testCase++)
    {
        cin >> testCase;

        queue<int>code;

        for(int i = 0; i < 8; i++)
        {
            int input;
            cin >> input;

            code.push(input);
        }

        int i = 1;
        while(1)
        {
            int encode = (code.front() - i <= 0) ? 0 : code.front() - i;
            code.pop();
            code.push(encode);

            if(encode == 0)
                break;

            i++;
            if(i == 6)
                i = 1;
        }

        cout << "#" << testCase << " ";
        for(int i = 0; i < 8; i++)
        {
            cout << code.front() << " ";
            code.pop();
        }
        cout << "\n";
    }

    return 0;
}