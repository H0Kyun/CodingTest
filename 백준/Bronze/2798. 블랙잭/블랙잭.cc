#include <iostream>

using namespace std;

int main () {
    int N = 0, M = 0;

    cin >> N >> M;

    int cards[N];

    for (int i = 0; i < N; ++i) {
        cin >> cards[i];
    }

    int largestTotal = 0;

    for (int i = 0; i < N; ++i) {
        for (int j = i + 1; j < N; ++j) {
            for (int k = j + 1; k < N; ++k) {
                int total = cards[i] + cards[j] + cards[k];

                if (total > largestTotal && total <= M) {
                    largestTotal = total;
                }
            }
        }
    }

    cout << largestTotal << endl;

    return 0;
}