// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14P0c6AAUCFAYi

#include<iostream>
#include<vector>

using namespace std;

vector<int> getPartialMatch(string& str)
{
    int strLength = str.length();
    vector<int> pi(strLength, 0);

    int start = 1, match = 0;
    while(start + match < strLength)
    {
        if(str[start + match] == str[match])
        {
            match++;
            pi[start + match - 1] = match;
        }
        else
        {
            if(match == 0) start++;
            else
            {
                start += match - pi[match - 1];
                match = pi[match - 1];
            }
        }
    }

    return pi;
}

int getMatch(string& pattern, string& source)
{
    int count = 0;
    int patternLength = pattern.length(), sourceLength = source.length();
    vector<int> pi = getPartialMatch(pattern);

    int start = 0, match = 0;
    while(start <= sourceLength - patternLength)
    {
        if(match < patternLength && source[start + match] == pattern[match])
        {
            match++;
            if(match == patternLength) count++;
        }
        else
        {
            if(match == 0) start++;
            else
            {
                start += match - pi[match - 1];
                match = pi[match - 1];
            }
        }
    }

    return count;
}

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for(int testCase = 1; testCase <= 10; testCase++)
    {
        cin >> testCase;

        string pattern;
        string source;

        cin >> pattern;
        cin >> source;

        int count = getMatch(pattern, source);
        
        cout << "#" << testCase << " " << count << "\n";
    }

    return 0;
}