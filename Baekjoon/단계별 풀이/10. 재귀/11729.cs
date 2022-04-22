// 문제 출처: https://www.acmicpc.net/problem/11729

using System;
using System.Text;

public class Test
{
    static StringBuilder sb = new StringBuilder();
    
	public static void Main()
	{
		int n = int.Parse(Console.ReadLine());
		
		int k = (int)Math.Pow(2, n) - 1;
		sb.Append(k);
		sb.Append("\n");
		
		hanoi(n, 1, 2, 3);
		Console.WriteLine(sb.ToString());
	}
	
	static void hanoi(int n, int a, int b, int c){
		if(n == 1){
			sb.AppendFormat("{0} {1}", a, c);
			sb.Append("\n");
		}else{
			hanoi(n-1, a, c, b);
			sb.AppendFormat("{0} {1}", a, c);
			sb.Append("\n");
			hanoi(n-1, b, a, c);
		}
	}
}
