import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class AppKtTest {
    @Test
    fun generateFull() {
        val seeds = listOf(
            listOf(0, 1, 2, 3),
            listOf(2, 1, 0, 3)
        )
        val trueResults = listOf(
            listOf(
                listOf(0, 1, 2, 3),
                listOf(2, 3, 0, 1),
                listOf(1, 0, 3, 2),
                listOf(3, 2, 1, 0),
            ), listOf(
                listOf(2, 1, 0, 3),
                listOf(0, 3, 2, 1),
                listOf(1, 2, 3, 0),
                listOf(3, 0, 1, 2),
            )
        )
        for (i in seeds.indices) {
            Assertions.assertArrayEquals(
                trueResults[i].toTypedArray(),
                generateFull(seeds[i]).toTypedArray()
            )
        }
    }
}