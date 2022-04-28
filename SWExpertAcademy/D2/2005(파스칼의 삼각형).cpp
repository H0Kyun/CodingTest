// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5P0-h6Ak4DFAUq

#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    int test_case;

    cin >> test_case;

    for(int i = 1; i <= test_case; i++)
    {
        int number;
        int pascal_triangle[10][10];
        
        cin >> number;

        cout << "#" << i << "\n";

        for(int j = 0; j < number; j++)
        {
            for(int k = 0; k <= j; k++)
            {
                if(k == 0 || k == j - 1)
                    pascal_triangle[j][k] = 1;
                else
                    pascal_triangle[j][k] = pascal_triangle[j-1][k-1] + pascal_triangle[j-1][k];
                cout << pascal_triangle[j][k] << " ";
            }
            cout << "\n";
        }     
    }

    return 0;
}