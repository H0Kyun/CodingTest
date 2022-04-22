// 문제 출처: https://www.acmicpc.net/problem/10430

import java.util.*

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    val A : Int = nextInt()
    val B : Int = nextInt()
    val C : Int = nextInt()
    
    println((A+B)%C)
    println(((A%C)+(B%C))%C)
    println((A*B)%C)
    println(((A%C)*(B%C))%C)
}
