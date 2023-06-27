// 문제 출처: https://www.acmicpc.net/problem/4344

using System;
using System.Text;

class Program
{
    static void Main(string[] args)
    {
        int i = 0, j = 0;
        
        int case_num = int.Parse(Console.ReadLine());
        float[] over_avg = new float[case_num];

        for(i=0; i<case_num; i++)
        {
            string[] str_score = Console.ReadLine().Split();
            int student_num = int.Parse(str_score[0]);

            float[] student_score = new float[student_num];
            float total_score = 0, avg_score = 0, count = 0;

            for(j=1; j<=student_num; j++)
            {
                student_score[j-1] = float.Parse(str_score[j]);
                total_score += student_score[j-1];
            }

            avg_score = total_score / student_num;

            for(j=0; j < student_num; j++)
            {
                if(student_score[j] > avg_score)
                {
                    count++;
                }
            }

            over_avg[i] = ( count / student_num ) * 100;

        }

        for(i=0; i<case_num; i++)
        {
            Console.WriteLine(((over_avg[i]).ToString("N3")) + "%");
        }
    }
}