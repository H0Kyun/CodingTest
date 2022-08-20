// 문제 출처: https://www.acmicpc.net/problem/8979

#include <iostream>
#include <vector>

using namespace std;

struct Country {
    int name;
    int gold;
    int silver;
    int bronze;
};

int main()
{
    ios::sync_with_stdio(false);
	cin.tie(NULL);
    
    int numberOfCountry, k, kGold, kSilver, kBronze, kRank = 1;
    cin >> numberOfCountry >> k;

    vector<Country> country(numberOfCountry);
    for(int i = 0; i < numberOfCountry; i++)
    {
		cin >> country[i].name >> country[i].gold >> country[i].silver >> country[i].bronze;
        if(country[i].name == k)
        {
            kGold = country[i].gold;
            kSilver = country[i].silver;
            kBronze = country[i].bronze;
        }
	}

    for(int i = 0; i < country.size(); i++) 
    {
        if(country[i].name == k) continue;
        if(country[i].gold > kGold) {
            kRank++;
        } else if(country[i].gold == kGold) {
            if (country[i].silver > kSilver) {
                kRank++;
            } else if(country[i].silver == kSilver) {
                if(country[i].bronze > kBronze) {
                    kRank++;
                }
            }
        }
    }
		
	cout << kRank;

    return 0;
}