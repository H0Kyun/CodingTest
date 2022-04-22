// 문제 출처: https://www.acmicpc.net/problem/10872

using System;
using System.Text;

public class Test
{
	public static void Main()
	{
		int n = int.Parse(Console.ReadLine());
		
		int fac_n = factorial(n);
		
		Console.WriteLine(fac_n);
		
	}
	
	static int factorial(int n){
		if(n == 1 || n == 0) return 1;
		else return factorial(n-1) * n;
	}
}
