import junit.framework.Assert.assertEquals
import org.junit.Test

class CollageTest {

    @Test
    fun simpleMontage(){
        val pictures = listOf(
            Picture(5, 2),
            Picture(5, 3)
        )

        val collage = Collage(pictures, 10, 10)

        assertEquals(2, collage.pictures.size)
        assertEquals(10, collage.width)
        assertEquals(3, collage.height)
    }
}