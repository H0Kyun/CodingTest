// 문제 출처: https://www.acmicpc.net/problem/12891

#include<iostream>
#include<vector>

using namespace std;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int DNALength, passwordLength;
	cin >> DNALength >> passwordLength;
	
    string DNA;
    int count = 0;
    cin >> DNA;

    int a, c, g, t;
    cin >> a >> c >> g >> t;
    int compareA = 0, compareC = 0, compareG = 0, compareT = 0;
    for(int i = 0; i < passwordLength; i++)
    {
        if(DNA[i] == 'A') compareA++;
        else if(DNA[i] == 'C') compareC++;
        else if(DNA[i] == 'G') compareG++;
        else if(DNA[i] == 'T') compareT++;
    }
	
    if(a <= compareA && c <= compareC && g <= compareG && t <= compareT)
        count++;

	for(int i = passwordLength; i < DNALength; i++)
    {
        if(DNA[i] == 'A') compareA++;
        else if(DNA[i] == 'C') compareC++;
        else if(DNA[i] == 'G') compareG++;
        else if(DNA[i] == 'T') compareT++;

        if(DNA[i - passwordLength] == 'A') compareA--;
        else if(DNA[i - passwordLength] == 'C') compareC--;
        else if(DNA[i - passwordLength] == 'G') compareG--;
        else if(DNA[i - passwordLength] == 'T') compareT--;

        if(a <= compareA && c <= compareC && g <= compareG && t <= compareT)
            count++;
    }

	cout << count;
	return 0;
}
