// Using Generics
//class Question<T>(
//    val questionText: String,
//    val answer: T,
//    val difficulty: String
//    )
//
//
//fun main() {
//   val question1 = Question<String>("Quoth the raven ___", "nevermore", "medium")
//    val question2 = Question<Boolean>("The sky is green? True or false", false, "easy" )
//    val question3 = Question<Int>("How many days are there between full moon", 28, "hard")
//}

//Use an enum class
//data class Question<T>(
//    val questionText: String,
//    val answer: T,
//    val difficulty: Difficulty
//)
//
//enum class Difficulty {
//    HARD, MEDIUM, EASY
//}
//
//class Quiz {
//    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
//    val question2 = Question<Boolean>("The sky is green? True or false", false, Difficulty.EASY)
//    val question3 = Question<Int>("How many days are there between full moon", 28, Difficulty.HARD)
//
//    companion object StudentProgress{
//        var total: Int = 10
//        var answered: Int = 3
//    }
//
//}
//
//val Quiz.StudentProgress.progressText: String
//    get() = "${answered} of  ${total} answered"
//
//fun Quiz.StudentProgress.printProgressBar() {
//    repeat(Quiz.answered) { print("#") }
//    repeat(Quiz.total - Quiz.answered){print("%")}
//    println()
//    println(Quiz.progressText)
//}
//
//fun main() {
//    Quiz.printProgressBar()
//}

//Rewrite Extension function using interface
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

enum class Difficulty {
    HARD, MEDIUM, EASY
}

interface ProgressPrintable{
    val progressText: String
    fun printProgressBar()
}

class Quiz: ProgressPrintable {
    val question1 = Question<String>("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = Question<Boolean>("The sky is green? True or false", false, Difficulty.EASY)
    val question3 = Question<Int>("How many days are there between full moon", 28, Difficulty.HARD)

    companion object StudentProgress{
        var total: Int = 10
        var answered: Int = 3
    }

    override val progressText: String
        get() = "$answered of $total answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("#") }
        repeat(Quiz.total - Quiz.answered){print("%")}
        println()
        println(progressText)
    }

    fun printQuiz() {
        question1.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question2.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
        question3.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        println()
    }
}



fun main() {
    Quiz().printProgressBar()
    Quiz().apply { printQuiz() }
}

