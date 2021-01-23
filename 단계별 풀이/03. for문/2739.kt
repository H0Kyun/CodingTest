// 문제 출처: https://www.acmicpc.net/problem/2739

import java.util.Scanner

fun main() = with (Scanner(System.`in`)){
    var A = nextInt()
    
    for(i in 1..9){
       print(A); print(" * "); print(i); print(" = "); println(A*i)
    }
}
