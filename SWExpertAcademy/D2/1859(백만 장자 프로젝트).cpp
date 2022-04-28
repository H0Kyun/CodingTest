// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LrsUaDxcDFAXc

#include<iostream>
#include<list>

using namespace std;

int main(int argc, char** argv)
{
    int test_case;
    int T;

    cin >> T;

    for(test_case = 1; test_case <= T; test_case++)
    {
        unsigned int number;

        cin >> number;

        list  <int> list_sale_price;
        int sale_price;
        int max_price = 0;
        long long benefit = 0;

        for(int i = 0; i < number; i++)
        {
            cin >> sale_price;
            
            list_sale_price.push_front(sale_price);
        }

        list<int>::iterator iterator_sale_price;

        for(iterator_sale_price = list_sale_price.begin(); iterator_sale_price != list_sale_price.end(); iterator_sale_price++)
        {
            if(*iterator_sale_price >= max_price)
            {
                max_price = *iterator_sale_price;
            }
            else
            {
                benefit += max_price - *iterator_sale_price;
            }
        }

        list_sale_price.clear();

        cout << "#" << test_case << " " << benefit << "\n";
    }

    return 0;
}