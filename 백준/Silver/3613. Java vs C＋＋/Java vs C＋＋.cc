#include<iostream>

using namespace std;

bool is_valid(string identifier);
string to_java(string identifier);
string to_cpp(string identifier);
string char_to_string(char c);

int main() {
    string identifier;

    cin >> identifier;

    if (is_valid(identifier)) {
        for (int i = 0; i < identifier.size(); ++i) {
            if (identifier[i] == '_') {
                cout << to_java(identifier) << endl;

                return 0;
            } else if (identifier[i] >= 'A' && identifier[i] <= 'Z') {
                cout << to_cpp(identifier) << endl;

                return 0;
            }
        }

        cout << identifier << endl;
    } else {
        cout << "Error!" << endl;
    }

    return 0;
}

bool is_valid(string identifier) {
    if (identifier[0] >= 'A' && identifier[0] <= 'Z') {
        return false;
    }

    if (identifier[0] == '_') {
        return false;
    }

    if (identifier[identifier.size() - 1] == '_') {
        return false;
    }

    bool has_uppercase = false;
    bool has_underscore = false;

    for (int i = 1; i < identifier.size(); ++i) {
        if (identifier[i] >= 'A' && identifier[i] <= 'Z') {
            has_uppercase = true;
        }

        if (identifier[i] == '_') {
            has_underscore = true;

            if (identifier[i - 1] == '_') {
                return false;
            }
        }
    }

    if (has_uppercase && has_underscore) {
        return false;
    }

    return true;
}

string to_java(string identifier) {
    for (int i = 0; i < identifier.size(); ++i) {
        if (identifier[i] == '_') {
            char id = toupper(identifier[i + 1]);

            identifier.replace(i, 2, char_to_string(id));
        }
    }

    return identifier;
}

string to_cpp(string identifier) {
    for (int i = 0; i < identifier.size(); ++i) {
        if (identifier[i] >= 'A' && identifier[i] <= 'Z') {
            char id = tolower(identifier[i]);

            identifier.replace(i, 1, "_" + char_to_string(id));
        }
    }

    return identifier;
}

string char_to_string(char c) {
    string str(1, c);

    return str;
}