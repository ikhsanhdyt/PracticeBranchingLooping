package app

import utils.CalculateUtils
import java.lang.NumberFormatException

class App {
    fun run() {
        printHeader()
        inputTotalStudents()
    }

    private fun printHeader() {
        println("========================")
        println("Students Averages Counting App")
        println("========================")
    }

    private fun inputTotalStudents() {
        var totalStudent = 0
        println("Enter total students = ")
        totalStudent = try {
            readLine()?.toInt() ?: 0
        }catch (e: NumberFormatException){
            0
        }
        if (totalStudent <= 1 || totalStudent >= 30){
            println("Total student must be an integer, more than 1 and max 30 !")
            inputTotalStudents()
        }else{
            inputScore(totalStudent)
        }
    }

    private fun inputScore(totalStudent: Int) {
        val scores = arrayListOf<Int>()
        for (i in 1..totalStudent){
            println("Insert student score number - $i :")
            var score = try {
                readLine()?.toInt() ?: 0
            }catch (e: NumberFormatException){
                101
            }
            if (score < 0 || score > 100) {
                println("Failed input,Please Try again!")
                inputTotalStudents()
            }else{
                scores.add(score)
            }
        }
        printResult(scores,totalStudent)
    }

    fun printResult(scores: ArrayList<Int>, totalStudent: Int) {
        val calculateUtils = CalculateUtils()
        println("========================")
        println("Total Students = $totalStudent")
        println("Total Scores = ${calculateUtils.totalScores(scores)}")
        println("Averages Scores = ${calculateUtils.averageScores(scores,totalStudent)}")
        println("========================")

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}