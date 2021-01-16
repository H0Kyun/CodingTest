// 문제 출처: https://www.acmicpc.net/problem/2438

using System;
using System.Text;

class Program{
    static void Main(string[] args){
        int i = 0, count = 0;
        
        count = int.Parse(Console.ReadLine());
        
        for(i=0; i<count; i++){
        	for(int j=0; j<=i; j++){
        		Console.Write("*");	
        	}
        	Console.WriteLine();
        }

    }
}
