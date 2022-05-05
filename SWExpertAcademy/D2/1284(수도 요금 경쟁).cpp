// 문제 출처: https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV189xUaI8UCFAZN

#include<cstdio>

using namespace std;

int main(int argc, char** argv)
{
	int test_case;
	int T;
	
	scanf("%d" , &T);
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
		int a_1L_price, b_basic_price, b_basic_amount, b_1L_price, j_month_amount;
        int a_pay, b_pay;

        scanf("%d %d %d %d %d", &a_1L_price, &b_basic_price, &b_basic_amount, &b_1L_price, &j_month_amount);

        a_pay = a_1L_price * j_month_amount;
        b_pay = b_basic_price;
        if(j_month_amount > b_basic_amount)
            b_pay += (j_month_amount - b_basic_amount) * b_1L_price;

        printf("#%d %d\n", test_case, a_pay >= b_pay ? b_pay : a_pay);
	}
	return 0;
}