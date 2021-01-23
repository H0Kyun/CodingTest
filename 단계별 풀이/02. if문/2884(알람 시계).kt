// 문제 출처: https://www.acmicpc.net/problem/2884

import java.util.Scanner

fun main() = with (Scanner(System.`in`)){
    var H = nextInt()
    var M = nextInt()
    
    if(M >= 45){
        M -= 45
        print("$H $M")
    }else{
        M += 15
        H--
        if(H < 0){
            H = 23
        }
        print("$H $M")
    }
}
