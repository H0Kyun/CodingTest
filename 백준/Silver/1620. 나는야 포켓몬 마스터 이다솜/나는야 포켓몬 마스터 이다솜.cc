#include<iostream>
#include<map>

using namespace std;

int main() {
    cin.tie(0);
    ios::sync_with_stdio(0);
    
    unsigned int n = 0;
    unsigned int m = 0;

    cin >> n >> m;

    map<string, string> number_book;
    map<string, unsigned int> name_book;


    for (unsigned int i = 1; i <= n; ++i) {
        string name;
        cin >> name;

        number_book.insert(make_pair(to_string(i), name));
        name_book.insert(make_pair(name, i));
    }

    string result;

    for (unsigned int i = 0; i < m; ++i) {
        string query;

        cin >> query;

        if (number_book.find(query) != number_book.end()) {
            result += number_book.find(query)->second + "\n";
        } else {
            result += to_string(name_book.find(query)->second) + "\n";
        }
    }

    cout << result;

    return 0;
}