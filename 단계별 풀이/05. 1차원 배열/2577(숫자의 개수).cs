// 문제 출처: https://www.acmicpc.net/problem/2577

using System;
using System.Text;

class Program
{
    static void Main(string[] args)
    {
        string str_result;
        int[] count = new int[10];
        int int_result = 1;

        for(int i=0; i<10; i++)
        {
            count[i] = 0;
        }

        for(int i=0; i<3; i++)
        {
            int_result *= int.Parse(Console.ReadLine());
        }

        str_result = int_result.ToString();
        char[] chr_result = str_result.ToCharArray();

        foreach(char element in chr_result){
            for(int i=0; i<10; i++)
            {
                if((i+48) == (int)element)
                {
                    count[i]++;
                }
            }
        }
       

        for(int i=0; i<10; i++)
        {
            Console.WriteLine(count[i]);
        }
    }
}