// 문제 출처: https://www.acmicpc.net/problem/2439

using System;
using System.Text;

class Program{
    static void Main(string[] args){
        int i = 0, count = 0;
        
        count = int.Parse(Console.ReadLine());
        
        for(i=1; i<=count; i++){
        	for(int j=0; j<count-i; j++){
        		Console.Write(" ");	
        	}
        	for(int j=0; j<i; j++ ){
        		Console.Write("*");
        	}
        	Console.WriteLine();
        }

    }
}
