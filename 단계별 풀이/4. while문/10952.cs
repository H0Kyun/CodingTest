// 문제 출처: https://www.acmicpc.net/problem/10952
// 문제 이름 추가

using System;
using System.Text;
using System.Collections.Generic;

class Program{
    static void Main(string[] args){
        int a =0, b =0, c = 0;
		
		do{
        	string[] ab = Console.ReadLine().Split(' ');
        	a = int.Parse(ab[0]);
        	b = int.Parse(ab[1]);
        	c = a + b;
        	if(c !=0){
        		Console.WriteLine(c);		    		
        	}
       	
		}while(a != 0 && b != 0);

        

    }
}
