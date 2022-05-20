// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXO72aaqPrcDFAXS

#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

vector<int> changeIntToVector(int number)
{
    vector<int>numbers;
    while(number/10 != 0)
    {
        numbers.push_back(number % 10);
        number /= 10;
    }
    numbers.push_back(number % 10);

    return numbers;
}

bool isPalindrome(int number)
{
    vector<int>numbers = changeIntToVector(number);
    int start = 0, end = numbers.size() - 1;
    while(start < end)
    {
        if(numbers[start] == numbers[end])
        {
            start++;
            end--;
        }
        else
        {
            return false;
        }
    }

    return true;
}

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int testCase, T;

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        int startNumber, endNumber;
        int numberOfPalindromes = 0;

        cin >> startNumber >> endNumber;

        for(int i = startNumber; i <= endNumber; i++)
        {
            if(isPalindrome(i))
            {
                if(sqrt(i) - (int)sqrt(i) == 0)
                    if(isPalindrome((int)sqrt(i)))
                        numberOfPalindromes++;
            }
        }        
        
        cout << "#" << testCase << " " << numberOfPalindromes << "\n";
    }

    return 0;
}