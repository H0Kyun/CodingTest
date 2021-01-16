// 문제 출처: https://www.acmicpc.net/problem/2742

import java.io.*
import java.util.*


fun main(args: Array<String>){

    try{
        val bw = BufferedWriter(OutputStreamWriter(System.`out`))
        val br = BufferedReader(InputStreamReader(System.`in`))
        val C = Integer.parseInt(br.readLine())
        for(i in C downTo 1){
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
