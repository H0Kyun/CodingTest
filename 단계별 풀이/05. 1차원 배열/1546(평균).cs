// 문제 출처: https://www.acmicpc.net/problem/1546

using System;
using System.Text;

class Program
{
    static void Main(string[] args)
    {
        int i = 0;

        int sbj_num = int.Parse(Console.ReadLine());

        double[] sbj_score = new double[sbj_num];
        string[] score = Console.ReadLine().Split(' ');

        for(i=0; i<sbj_num; i++)
        {
            sbj_score[i] = double.Parse(score[i]);
        }

        double max_score = MaxScore(sbj_score);
        double total_score = 0;

        for(i=0; i<sbj_num; i++)
        {
            sbj_score[i] = (sbj_score[i] / max_score) * 100;
            total_score += sbj_score[i];
        }

        Console.WriteLine((double)(total_score/sbj_num));
    }

    static double MaxScore(double[] array)
    {
        double max_score = array[0];
        int i = 0;

        for(i=1; i<array.Length; i++)
        {
            if(max_score < array[i])
            {
                max_score = array[i];
            }
        }

        return max_score;
    }
}