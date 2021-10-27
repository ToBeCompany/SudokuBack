import java.util.*

fun main() {
    val game = Game(random(4))
    show(game.mutablezeros)
    while(true) {
        println("выбери строку")
        val stage = readLine()!!.toInt() - 1
        println("выбери столб")
        val value = readLine()!!.toInt() - 1
        println("выбери правильное число")
        val truevalue = readLine()!!.toInt()
        val answer = game.put(stage, value, truevalue)
        show(game.mutablezeros)
        if(answer == Answer.Done) {
            println("nice work")
            break
        } else if(answer == Answer.Illegal) {
            println("уже был заполнен")
        }
        println(answer)
    }
}

fun show(list : List<List<Int>>) {
    list.forEach {
        println(it)
    }
}

fun<T> List<T>.shift(int : Int = 1): List<T> {
    val list = toMutableList()
    Collections.rotate(list, -int)
    return list
}

fun<T> List<T>.subshift(circleQuantity : Int): List<T> {
    val circleLength = size / circleQuantity
    val circles = List(circleQuantity){
        this.subList(it * circleLength, it * circleLength + circleLength)
            .shift()
    }
    return circles.flatten()
}

fun random(n : Int)=List(n) { it + 1}.shuffled()