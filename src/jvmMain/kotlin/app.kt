import kotlin.random.Random

fun main() {
    show(generateFull(4))
}
fun generateFull(seed : List<Int>): List<List<Int>> {
    val box : MutableList<List<Int>> = MutableList(4) {
        MutableList(4) {
            //Random.nextInt(1, 10)
            it
        }
    }
    box[0] = seed
    box[1] = box[0].drop(2) + box[0].dropLast(2)
    val sub1 = box[0].subList(0, 2)
    val sub2 = box[0].subList(2, 4)
    box[2] = sub1.drop(1) + sub1.dropLast(1) + sub2.drop(1) + sub2.dropLast(1)
    val sub3 = box[1].subList(0, 2)
    val sub4 = box[1].subList(2, 4)
    box[3] = sub3.drop(1) + sub3.dropLast(1) + sub4.drop(1) + sub4.dropLast(1)
    return box
}

fun generateFull(size : Int): List<List<Int>> {
    val box : MutableList<List<Int>> = MutableList(size) {
        MutableList(size) {
            //Random.nextInt(1, 10)
            it
        }
    }
    box[1] = box[0].drop(2) + box[0].dropLast(2)
    val sub1 = box[0].subList(0, 2)
    val sub2 = box[0].subList(2, 4)
    box[2] = sub1.drop(1) + sub1.dropLast(1) + sub2.drop(1) + sub2.dropLast(1)
    val sub3 = box[1].subList(0, 2)
    val sub4 = box[1].subList(2, 4)
    box[3] = sub3.drop(1) + sub3.dropLast(1) + sub4.drop(1) + sub4.dropLast(1)
    return box
}

fun show(list : List<List<Int>>) {
    list.forEach {
        println(it)
    }
}