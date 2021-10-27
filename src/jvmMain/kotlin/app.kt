import java.util.*
import kotlin.math.sqrt
import kotlin.random.Random

fun main() {
    val random = random(9)
    val full = generateFull(random)
    val zeros = generateWithZeros(full, 50) as MutableList<MutableList<Int>>
    show(zeros)
    while(true) {
        println("выбери столбик")
        val stage = readLine()!!.toInt() - 1
        println("выбери не заполненное число")
        val value = readLine()!!.toInt() - 1
        println("выбери правильное число")
        val truevalue = readLine()!!.toInt()
        zeros[stage][value] = truevalue
        show(zeros)
        if(zeros == full) {
            println("nice work")
            break
        }
    }
}
fun generateFull(seed : List<Int>): List<List<Int>> {
    val box : MutableList<List<Int>> = MutableList(1) {
        MutableList(seed.size) {
            seed[it]
        }
    }
    val size = sqrt(seed.size.toDouble()).toInt()

    for(i in 0 until size - 1) {
        box.add(box[i].shift(size))
    }
    if(size > 2) {
        for(i in 0 until size - 1) {
            box.add(box[i].subshift(size))
        }
    } else {
        for(i in 0 until size) {
            box.add(box[i].subshift(size))
        }
    }
    if(size > 2) {
        for (i in 2 until size * 2 - 1) {
            box.add(box[i].subshift(size))
        }
    }
    return box
}

fun generateWithZeros(seed : List<List<Int>>, percent : Int ) = seed.map { row ->
    row.map {
        if (Random.nextInt(100) < percent) 0 else it
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