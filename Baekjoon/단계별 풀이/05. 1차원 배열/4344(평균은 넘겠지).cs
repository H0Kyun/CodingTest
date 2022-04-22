// 문제 출처: https://www.acmicpc.net/problem/4344

using System;
using System.Text;

class Program
{
    static void Main(string[] args)
    {
        int i = 0, j = 0;
        
        // 테스트 케이스 숫자
        int case_num = int.Parse(Console.ReadLine());
        
        // 평균을 넘은 비율을 저장할 배열
        float[] over_avg = new float[case_num];

        for(i=0; i<case_num; i++)
        {
            // Split을 이용해 입력받은 문자열을 띄어쓰기기준으로 나눈다.
            string[] str_score = Console.ReadLine().Split();
            
            // 가장 첫번째 문자열을 학생수로 정한다. 
            int student_num = int.Parse(str_score[0]);

            // 학생들 점수를 저장할 배열(꼭 필요하지는 않다.)
            float[] student_score = new float[student_num];
            
            float total_score = 0, avg_score = 0, count = 0;


            // 학생들 총점을 구한다.
            for(j=1; j<=student_num; j++)
            {
                student_score[j-1] = float.Parse(str_score[j]);
                total_score += student_score[j-1];
            }

            // 평균을 구한다.
            avg_score = total_score/(float.Parse(str_score[0]));

            // 평균 이상인 점수가 있으면 count를 1증가한다.
            for(j=0; j<student_num; j++)
            {
                if(student_score[j] > avg_score)
                {
                    count++;
                }
            }

            // 평균 넘긴 비율을 미리 만든 배열에 저장한다.
            over_avg[i] = ( count / (float.Parse(str_score[0])) ) * 100;

        }

        for(i=0; i<case_num; i++)
        {
            /* 처음에는 아래와 같은 방식으로 평균을 출력했으나 
            (테스트 예제 기준으로)출력 내용은 맞으나 틀렸다고 나왔다.
            이후 인터넷에서 찾은 출력 방식이 아래의 2)
            Console.WriteLine("{0:.000}%", over_avg[i]);
            */

            // 2)
            Console.WriteLine(((over_avg[i]).ToString("N3")) + "%");

            // 아래의 방식으로도 정답처리가 된 것 같다.
            // Console.WriteLine("{0:#.000%}", over_avg[i]);
        }
    }
}