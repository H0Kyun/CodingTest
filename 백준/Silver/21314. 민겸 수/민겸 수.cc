#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string str;
    cin >> str;
    int count = 0;
    string min = "";
    string max = "";

    for(int i = 0, size = str.length(); i < size; i++) {
			if (str[i] == 'M') count++;
			else {
				if(count != 0) min += "1";
				for(int j = 0; j < count - 1; j++)
					min += "0";
				min += "5";
				max += "5";
				for(int j = 0; j < count; j++)
					max += "0";
				count = 0;
			}
		}
		
		if(count != 0) {
			min += "1";
			max += "1";
			for(int i = 0; i < count - 1; i++) {
				min += "0";
			    max += "1";
			}
		}
		
		cout << max << "\n" << min;

    return 0;
}