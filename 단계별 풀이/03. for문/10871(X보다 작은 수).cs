// 문제 출처: https://www.acmicpc.net/problem/10871

using System;
using System.Text;

class Program{
    static void Main(string[] args){
        int n = 0, x = 0;
        
        string[] nx = Console.ReadLine().Split(' ');
        n = int.Parse(nx[0]);
        x = int.Parse(nx[1]);
        
        int[] array = new int[n];
        string[] inarray = Console.ReadLine().Split(' ');
        
        
        for(int i=0; i<n; i++){
        	array[i] = int.Parse(inarray[i]);
        	if(array[i] < x){
        		Console.Write("{0} ", array[i]);
        	}
        }

    }
}
