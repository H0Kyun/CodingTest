// 문제 출처: https://www.acmicpc.net/problem/2447

using System;
using System.Text;

public class Test
{
	static char[,] array;
	
	public static void Main()
	{
		int n = int.Parse(Console.ReadLine());
    
    //StringBuilder를 사용하지 않으면 시간초과가 발생한다.
		StringBuilder sb = new StringBuilder(); 
		
		array = new char[n,n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				array[i,j] = ' ';
			}
		}

		star(0, 0, n);
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				sb.Append(array[i,j]);
			}
			sb.Append("\n");
		}
		
		
		Console.Write(sb.ToString());
		
	}
	
	static void star(int x, int y, int n){
		int k = n/3;
		
		if(n == 1){
			array[x,y] = '*';
			return;
		}
		
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(i == 1 && j == 1){
					continue;
				}else{
					star(x+(i*k), y+(j*k), k);
				}
			}
		}
	}
}
