// 문제 출처: https://www.acmicpc.net/problem/11022

using System;
using System.Text;

class Program{
    static void Main(string[] args){
        int i = 0, count = 0;
        
        count = int.Parse(Console.ReadLine());
        
        int[] a = new int[count];
        int[] b = new int[count];
        
        for(i=0; i<count; i++){
            string[] ab = Console.ReadLine().Split();
            a[i] = int.Parse(ab[0]);
            b[i] = int.Parse(ab[1]);
        }
        
        for(i=0; i<count; i++){
            int c = a[i] + b[i];
            int ca = i+1;
            Console.WriteLine("Case #{0}: {1} + {2} = {3}", ca, a[i], b[i], c);
        }
    }
}
