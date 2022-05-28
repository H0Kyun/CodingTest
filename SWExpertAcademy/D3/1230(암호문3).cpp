// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14zIwqAHwCFAYD#none

#include<iostream>
#include<vector>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int testCase;

    for(testCase = 1; testCase <= 10; testCase++)
    {
        int passwordLength;
        cin >> passwordLength;

        vector<int> password(passwordLength);
        for(int i = 0; i < passwordLength; i++)
            cin >> password[i];

        int numberOfCommands;
        cin >> numberOfCommands;

        for(int i = 0; i < numberOfCommands; i++)
        {
            char command;
            int index;
            int number;
            cin >> command;

            if(command == 'I')
            {
                cin >> index >> number;
                for(int j = 0; j < number; j++)
                {
                    int insertNumber;
                    cin >> insertNumber;

                    password.insert(password.begin() + index + j, insertNumber);
                }
            }
            else if(command == 'D')
            {
                cin >> index >> number;
                password.erase(password.begin() + index, password.begin() + index + number);
            }
            else
            {
                cin >> number;
                for(int j = 0; j < number; j++)
                {
                    int appendNumber;
                    cin >> appendNumber;

                    password.push_back(appendNumber);
                }
            }
        }
        
        cout << "#" << testCase << " ";
        for(int i = 0; i < 10; i++)
            cout << password[i] << " ";
        cout << "\n";
    }

    return 0;
}