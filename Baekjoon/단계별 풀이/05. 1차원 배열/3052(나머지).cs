// 문제 출처: https://www.acmicpc.net/problem/3052

using System;
using System.Text;

class Program
{
    static void Main(string[] args)
    {
        int[] result = new int[10];
        int j = 0, i = 0;

        for(i=0; i<10; i++)
        {
            result[i] = int.Parse(Console.ReadLine()) % 42;
        }

        /*
        처음에는 1)과 같은 방식으로 같은 수의 개수를 거를려 했지만 이 경우
        입력이 1 2 1 2.... 와 같이 같은 숫자가 번갈아 나오는 경우 
        결과값이 올바르게 나오지 않았다.
        그래서 인터넷에서 찾은 것이 2) 방법
        
        1)
        int count = 10;

        for(j=0; j<10; j++)
        {

            // 이전 나머지와 값이 같으면 넘김
            if(j > 0)
            {
                if(result[j]==result[j-1]) continue;
            }

            // 같으면 count를 뺌
            for(i=j+1; i<10; i++)
            {
                if(result[j]==result[i]) count--;
            }
        }
        */

        /*2) 42로 나눈 나머지가 0~41범위안에 드는 것을
        bool 배열을 통해 활용한다.
        */
        int count = 0;
        bool[] check = new bool[42];

        for(j=0; j<10; j++)
        {
            for(i=0; i<42; i++)
            {
                if(result[j]==i) check[i] = true;
            }
        }
        
        for(i=0; i<check.Length; i++)
        {
            if(check[i]) count++;    
        }

        Console.WriteLine(count);
    }
}