import java.util.*
import kotlin.random.Random

fun main() {
    show(generateFull(4))
}
fun generateFull(seed : List<Int>): List<List<Int>> {
    val box : MutableList<List<Int>> = MutableList(1) {
        MutableList(seed.size) {
            //Random.nextInt(1, 10)
            seed[it]
        }
    }
    if(seed.size % 3 == 0) {
        val size = seed.size / 3
        box.add(box[0].shift(size * 2) as List<Int>)
        box.add(box[1].subshift() as List<Int>)
        box.add(box[0].subshift() as List<Int>)
    } else {
        box.add(box[0].shift(2) as List<Int>)
        box.add(box[1].subshift() as List<Int>)
        box.add(box[0].subshift() as List<Int>)
    }
    println(box)
    return box
}

fun generateFull(size : Int): List<List<Int>> {
    val box : MutableList<List<Int>> = MutableList(1) {
        MutableList(size) {
            //Random.nextInt(1, 10)
            it
        }
    }
    box.add(box[0].drop(2) + box[0].dropLast(2))
    val sub1 = box[0].subList(0, 2)
    val sub2 = box[0].subList(2, 4)
    box.add(sub1.drop(1) + sub1.dropLast(1) + sub2.drop(1) + sub2.dropLast(1))
    val sub3 = box[1].subList(0, 2)
    val sub4 = box[1].subList(2, 4)
    box.add(sub3.drop(1) + sub3.dropLast(1) + sub4.drop(1) + sub4.dropLast(1))
    return box
}

fun show(list : List<List<Int>>) {
    list.forEach {
        println(it)
    }
}

fun List<Any>.shift(int : Int = 1): List<Any> {
    val list = this.toMutableList()
    Collections.rotate(list, -int)
    return list
}

fun List<Any>.subshift(int : Int = 1): List<Any> {
    var sub1 = this.subList(int - 1, int + 1)
    var sub2 = this.subList(int + 1, int + 1 + int + 1)
    sub1 = sub1.shift() as MutableList<Any>
    sub2 = sub2.shift() as MutableList<Any>
    return sub2 + sub1
}