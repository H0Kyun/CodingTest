// 문제 출처: https://www.acmicpc.net/problem/10818

using System;
using System.Text;

class Program{
    static void Main(string[] args){
        int n = 0;
        
        n = int.Parse(Console.ReadLine());
        
        int[] array = new int[n];
        string[] inarray = Console.ReadLine().Split(' ');
        
        
        for(int i=0; i<n; i++){
        	array[i] = int.Parse(inarray[i]);
        }

		int max = array[0], min = array[0];

		for(int i=1; i<n; i++){
			if(max < array[i]){
				max = array[i];
			}
			if(min > array[i]){
				min = array[i];
			}
        }

		StringBuilder sb = new StringBuilder();
		sb.Append(min.ToString());
		sb.Append(' ');
		sb.Append(max.ToString());

		Console.Write(sb.ToString());

    }
}