// 문제 출처: https://www.acmicpc.net/problem/2741

import java.io.*
import java.util.*


fun main(args: Array<String>){

    try{
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val br = BufferedReader(InputStreamReader(System.`in`))
        val C = Integer.parseInt(br.readLine())
        for(i in 1..C){
            bw.write(i.toString() + "\n")
            bw.flush()
        }
        bw.close()
    }catch( e : IOException){
        e.printStackTrace()
    }catch( e : NumberFormatException){
        e.printStackTrace()
    }



}
