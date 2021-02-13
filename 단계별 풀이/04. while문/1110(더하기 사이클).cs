// 문제 출처: https://www.acmicpc.net/problem/1110

using System;
using System.Text;

class Program{
	
    static void Main(string[] args){
        int a = 0, x = 0, n = 0;
        int a1 = 0, a10 = 0;

		a = int.Parse(Console.ReadLine());
		x = a;
		
		do{
			
			a1 = a % 10;
			a10 = a / 10;
			
			a = ((a1+a10) % 10) + (a1*10);
			
			n++;
		}while(a != x);
	
		
		Console.WriteLine(n);

        

    }
}
