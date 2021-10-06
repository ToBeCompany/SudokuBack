import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class AppKtTest {
    @Test
    fun generateFullFor4() {
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

    @Test
    fun generateFullFor9() {
        val seeds = listOf(
            listOf(0, 1, 2, 3, 4, 5, 6, 7, 8),
        )
        val trueResults = listOf(
            listOf(
                listOf(0, 1, 2, 3, 4, 5, 6, 7, 8),
                listOf(3, 4, 5, 6, 7, 8, 0, 1, 2),
                listOf(6, 7, 8, 0, 1, 2, 3, 4, 5),

                listOf(2, 0, 1, 5, 3, 4, 8, 6, 7),
                listOf(5, 3, 4, 8, 6, 5, 2, 0, 1),
                listOf(8, 6, 7, 2, 0, 1, 5, 3, 4),

                listOf(1, 2, 0, 4, 5, 3, 7, 8, 6),
                listOf(4, 5, 3, 5, 8, 6, 1, 2, 0),
                listOf(7, 8, 6, 2, 0, 1, 4, 5, 3),
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