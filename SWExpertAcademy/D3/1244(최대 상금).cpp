// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15Khn6AN0CFAYD

#include<algorithm>
#include<iostream>
#include<vector>
#include<cmath>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int testCase, T;

    cin >> T;

    for(testCase = 1; testCase <= T; testCase++)
    {
        int maxPrizeMoney;
        int number, numberOfExchange;

        cin >> number >> numberOfExchange;

        vector<int> numbers;
        vector<int> compareNumbers;
        
        while(number != 0)
        {
            numbers.push_back(number % 10);
            compareNumbers.push_back(number % 10);
            number /= 10;
        }

        sort(compareNumbers.begin(), compareNumbers.end(), greater<>());
        reverse(numbers.begin(), numbers.end());

        bool isDuplicate = false;
        bool isMaximumDuplicate = false;

        for(int i = 0; i + 1 < numbers.size(); i++)
        {
            if (compareNumbers[i] == compareNumbers[i + 1])
            {
                if (i == 0)
                    isMaximumDuplicate = true;

                isDuplicate = true;
                break;
            }
        }

        int i = 0;
        int j = 0;
        while (numberOfExchange > 0)
        {
            if (numbers[i] != compareNumbers[i])
            {
                if (isMaximumDuplicate)
                {
                    for(j = numbers.size() - 1; j > i; j--)
                    {
                        if (numbers[i] == compareNumbers[j])
                        {
                            int temp = numbers[j];
                            numbers[j] = numbers[i];
                            numbers[i] = temp;
                            numberOfExchange--;
                            break;
                        }
                    }

                }
                else
                {
                    for(j = numbers.size() - 1; j > i; j--)
                    {
                        if (numbers[j] == compareNumbers[i])
                        {
                            int temp = numbers[j];
                            numbers[j] = numbers[i];
                            numbers[i] = temp;
                            numberOfExchange--;
                            break;
                        }
                    }

                }
            }

            i++;
            if (i == numbers.size())
                break;
            
        }

        if (numberOfExchange > 0 && numberOfExchange % 2 != 0 && !isDuplicate)
        {
            int temp = numbers[numbers.size() - 1];
            numbers[numbers.size() - 1] = numbers[numbers.size() - 2];
            numbers[numbers.size() - 2] = temp;
        }

        number = 0;

        for (int i = numbers.size() - 1; i > 0; i--)
        {
            number += numbers[numbers.size() - i - 1] * int(pow(10, i));
        }

        number += numbers.back();
        

        cout <<"#" << testCase << " " << number << "\n";
    }

    return 0;
}