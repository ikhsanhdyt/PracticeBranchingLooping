package utils

class CalculateUtils {
    fun totalScores(scores: ArrayList<Int>) : Int {
        return scores.sum()
    }

    fun averageScores(scores: ArrayList<Int>,totalScores:Int) : Double {
        return scores.sum()/totalScores.toDouble()
    }
}