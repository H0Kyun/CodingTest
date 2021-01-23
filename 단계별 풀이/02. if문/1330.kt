// 문제 출처: https://www.acmicpc.net/problem/1330

import java.util.Scanner

fun main() = with (Scanner(System.`in`)){
    val a = nextInt()
    val b = nextInt()
    if(a>b){
        print(">")
    }else if(a<b){
        print("<")
    }else{
        print("==")
    }
}
