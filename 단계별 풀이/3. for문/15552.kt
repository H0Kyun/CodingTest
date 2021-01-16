// 문제 출처: https://www.acmicpc.net/problem/15552

import java.io.*
import java.util.*


fun main(args: Array<String>){

    try{
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val br = BufferedReader(InputStreamReader(System.`in`))
        val C = Integer.parseInt(br.readLine())
        for(i in 1..C){
            val token = StringTokenizer(br.readLine())
            val T  = Integer.parseInt(token.nextToken())
            val A  = Integer.parseInt(token.nextToken())
            val Sum = T+A

            bw.write(Sum.toString() + "\n")
            bw.flush()
        }
        bw.close()
    }catch( e : IOException){
        e.printStackTrace()
    }catch( e : NumberFormatException){
        e.printStackTrace()
    }
}
