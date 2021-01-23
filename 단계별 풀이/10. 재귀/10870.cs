// 문제 출처: https://www.acmicpc.net/problem/10870

using System;
using System.Text;

public class Test
{
	public static void Main()
	{
		int n = int.Parse(Console.ReadLine());
		
		int fib_n = fibonacci(n);
		
		Console.WriteLine(fib_n);
		
	}
	
	static int fibonacci(int n){
		if(n == 0){
			return 0;
		}else if(n <= 2){
			return 1;
		}else{
			return fibonacci(n-1) + fibonacci(n-2);	
		}
	}
}
