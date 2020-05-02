import junit.framework.Assert.assertEquals
import org.junit.Test

class MontageTest {

    @Test
    fun simpleMontage(){
        val pictures = listOf(
            Picture(5, 2),
            Picture(5, 3)
        )
        val picsByWidth = pictures.sortedBy { it.width }
        val picsByHeight = pictures.sortedBy { it.height }

        val montage = Montage(picsByWidth, picsByHeight, 10, 10)

        assertEquals(2, montage.pictures.size)
        assertEquals(10, montage.width)
        assertEquals(3, montage.height)
    }
}