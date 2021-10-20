import java.util.*
import kotlin.math.sqrt

fun main() {
    show(generateFull(listOf(0,1,2,3)))
}
fun generateFull(seed : List<Int>): List<List<Int>> {
    val box : MutableList<List<Int>> = MutableList(1) {
        MutableList(seed.size) {
            seed[it]
        }
    }
    val size = sqrt(seed.size.toDouble()).toInt()

    box.add(box[0].shift(size) )
    box.add(box[1].subshift(size) )
    box.add(box[0].subshift(size) )
    println(box)
    return box
}

fun show(list : List<List<Int>>) {
    list.forEach {
        println(it)
    }
}

fun<T> List<T>.shift(int : Int = 1): List<T> {
    val list = this.toMutableList()
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