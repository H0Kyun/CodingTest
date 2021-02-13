// 문제 출처: https://www.acmicpc.net/problem/2562

using System;
using System.Text;

class Program{
    static void Main(string[] args){
        int i = 0;
        int[] array = new int[9];
       
        for(i=0; i<9; i++){
        	array[i] = int.Parse(Console.ReadLine());
        }

		int max = array[0], max_num = 1;

		for(i=1; i<9; i++){
			if(max < array[i]){
				max = array[i];
                max_num = i+1;
			}
        }

		StringBuilder sb = new StringBuilder();
		sb.AppendLine(max.ToString());
		sb.Append(max_num.ToString());

		Console.Write(sb.ToString());

    }
}