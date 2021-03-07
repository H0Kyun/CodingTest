// 문제 출처: https://www.acmicpc.net/problem/4673

using System;
using System.Text;

class Program
{
    //1~10000까지의 수 중 셀프넘버를 체크할 배열
    static bool[] self_num = new bool[10001];

    static void Main(string[] args)
    {
        for(int i=1; i<10001; i++)
        {
            SelfNumber(i);
            if(!self_num[i]) Console.WriteLine(i);
        }
    }

    static void SelfNumber(int a)
    {
        int n = a;
        n = n + n/1000 + (n/100-(n/1000*10)) + (n/10-(n/100*10)) + n%10;

        //계산식에 의해 구해진 수는 셀프넘버가 아니므로 출력이 안되게 한다. 
        if(n <= 10000)
        {
            self_num[n] = true;
            return;
        }
    }
}