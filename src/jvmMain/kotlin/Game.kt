import kotlin.math.sqrt
import kotlin.random.Random

class Game(random : List<Int>) {
    private val full = generateFull(random)
    private val zeros = generateWithZeros(full, 10)
    val mutablezeros = zeros as MutableList<MutableList<Int>>
    fun put(stage : Int, value : Int, answer : Int) : Answer {
        return if(zeros[stage][value] == 0) {
            if(full[stage][value] == answer) {
                mutablezeros[stage][value] = answer
                if(full == mutablezeros) Answer.Done else Answer.True
            } else {
                mutablezeros[stage][value] = answer
                Answer.False
            }
        } else Answer.Illegal
    }
}

enum class Answer {
    True, False, Done, Illegal
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