// 문제 출처: https://www.acmicpc.net/problem/10951
// 문제이름 추가

using System;
using System.Text;
using System.Collections.Generic;

class Program{
    static void Main(string[] args){
        int a =0, b =0, c = 0;
		string ab;
		string[] spl_ab;

		while((ab = Console.ReadLine()) != null){
			spl_ab = ab.Split(' ');
			a = int.Parse(spl_ab[0]);
        	b = int.Parse(spl_ab[1]);
        	c = a + b;
        	Console.WriteLine(c);
		}

        

    }
}
