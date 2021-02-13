// 문제 출처: https://www.acmicpc.net/problem/9498

import java.util.Scanner

fun main() = with (Scanner(System.`in`)){
    var a = nextInt()
    
    when(a){
        in 90..100 -> print("A")
        in 80..89 -> print("B")
        in 70..79 -> print("C")
        in 60..69 -> print("D")
        else -> print("F")
    }
}
