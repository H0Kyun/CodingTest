// 문제 출처: https://www.acmicpc.net/problem/11021

import java.io.*
import java.util.*


fun main(args: Array<String>){

    try{
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val br = BufferedReader(InputStreamReader(System.`in`))
        val TestCase = Integer.parseInt(br.readLine())
        for(i in 1..TestCase){
            val token = StringTokenizer(br.readLine())
            val A = Integer.parseInt(token.nextToken())
            val B = Integer.parseInt(token.nextToken())
            val Sum = A + B
            bw.write("Case #${i}: " + Sum.toString() + "\n")
            bw.flush()
        }
        bw.close()

    }catch( e : IOException){
        e.printStackTrace()
    }catch( e : NumberFormatException){
        e.printStackTrace()
    }



}
