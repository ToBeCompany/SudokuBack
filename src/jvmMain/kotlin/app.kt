import java.util.*
import kotlin.math.sqrt
import kotlin.random.Random

fun main() {
    val random = random()
    val full = generateFull(random)
    val zeros = generateWithZeros(random)
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
fun generateFull(seed : List<Int>): MutableList<List<Int>> {
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

fun generateWithZeros(seed : List<Int>): MutableList<MutableList<Int>> {
    val list = generateFull(seed) as MutableList<MutableList<Int>>
    for(i in 0..4) {
        list[Random.nextInt(1, seed.size)][Random.nextInt(seed.size - 1)] = 0
    }
    return list
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

fun<T>  List<T>.subshift(circleQuantity : Int): List<T> {
    val circleLength = size / circleQuantity
    val circles = List(circleQuantity){
        this.subList(it * circleLength, it * circleLength + circleLength)
            .shift()
    }
    return circles.flatten()
}

fun random(): List<Int> {
    val list = MutableList(8) {
        it + 1
    }
    return (0..3).map {
        val random = list.random()
        list.remove(random)
        random
    }
}