// 문제 출처: https://www.acmicpc.net/problem/14681

import java.util.Scanner

fun main() = with (Scanner(System.`in`)){
    var x = nextInt()
    var y = nextInt()
    
    if(x>0){
        if(y>0){
            print(1)
        }else print(4)
    }else{
        if(y>0){
            print(2)
        }else print(3)
    }
}
