// 문제 출처: https://swexpertacademy.com/main/code/problem/problemSolver.do?contestProbId=AV14w-rKAHACFAYD

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

        vector<string> password(passwordLength);

        for(int i = 0; i < passwordLength; i++)
            cin >> password[i];

        int numberOfCommands;
        cin >> numberOfCommands;

        for(int i = 0; i < numberOfCommands; i++)
        {
            char command;
            int index;
            int number;
            cin >> command >> index >> number;
            for(int j = 0; j < number; j++)
            {
                string insertNumber;
                cin >> insertNumber;

                password.insert(password.begin() + index + j, insertNumber);
            }
        }
        
        cout << "#" << testCase << " ";
        for(int i = 0; i < 10; i++)
            cout << password[i] << " ";
        cout << "\n";
    }

    return 0;
}