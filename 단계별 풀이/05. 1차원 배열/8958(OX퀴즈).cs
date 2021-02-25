// 문제 출처: https://www.acmicpc.net/problem/8958

using System;
using System.Text;

class Program
{
    static void Main(string[] args)
    {
        int i = 0, j = 0, score = 0;

        int case_num = int.Parse(Console.ReadLine());

        int[] result = new int[case_num];

        for(i=0; i<case_num; i++)
        {
            //입력 받은 문자열을 ToCharArray를 통해 char형 배열로 옮겨 담았다.
            string ox = Console.ReadLine();
            char[] chr_ox = ox.ToCharArray();
            
            result[i] = 0;
            score = 0;
            
            for(j=0; j<chr_ox.Length; j++)
            {
                if(chr_ox[j] == 'O')
                {
                    score++; // O가 연속된 만큼 점수를 1씩높인다.
                }
                else
                {
                    score = 0; // O가 끊기면 점수를 0으로 초기화 한다.
                }
                result[i] += score;
            }
        }

        for(i=0; i<case_num; i++)
        {
            Console.WriteLine(result[i]);
        }
    }
}