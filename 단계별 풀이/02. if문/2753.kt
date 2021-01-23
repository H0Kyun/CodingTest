// 문제 풀이: https://www.acmicpc.net/problem/2753

import java.util.Scanner

fun main() = with (Scanner(System.`in`)){
    var a = nextInt()
    if(a%4 == 0){
        if(a%100 != 0 || a%400 == 0 ){
            print(1)
        }else print(0)
    }else print(0)
}
