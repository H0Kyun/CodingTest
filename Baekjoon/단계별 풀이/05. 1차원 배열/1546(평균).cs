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


        // 입력받은 점수를 double형으로 변환해준다.
        for(i=0; i<sbj_num; i++)
        {
            sbj_score[i] = double.Parse(score[i]);
        }

        double max_score = MaxScore(sbj_score);
        double total_score = 0;

        // 배열 내에 모든 수에 대해 '점수/최대점수 * 100'을 해준다.
        for(i=0; i<sbj_num; i++)
        {
            sbj_score[i] = (sbj_score[i] / max_score) * 100;
            total_score += sbj_score[i];
        }

        // 평균을 구해 화면에 출력
        Console.WriteLine((double)(total_score/sbj_num));
    }

    // 주어진 수에서 최대값을 구하는 메소드
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