// 문제 출처: https://www.acmicpc.net/problem/8393

import java.util.Scanner

fun main() = with (Scanner(System.`in`)){
    val n = nextInt()
    var sum = 0
    
    for(i in n downTo 1 ){
        sum += i    
    }
    println(sum)
}
