import java.util.*
import kotlin.math.sqrt
import kotlin.random.Random

fun main() {
    show(generateWithZeros(listOf(0,1,2,3,4,5)))
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
        for (i in 2 until size * 2) {
            box.add(box[i].subshift(size))
        }
    }
    return box
}

fun generateWithZeros(seed : List<Int>): MutableList<MutableList<Int>> {
    val list = generateFull(seed) as MutableList<MutableList<Int>>
    for(i in 0..4) {
        list[Random.nextInt(seed.size - 1)][Random.nextInt(seed.size - 1)] = 0
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