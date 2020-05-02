import junit.framework.Assert.assertEquals
import org.junit.Test

class CollageMakerTest {

    @Test
    fun createAMontage(){
        val pictures = listOf(
            Picture(5, 2),
            Picture(5, 3)
        )
        val maker = CollageMaker(pictures, 10, 10)

        assertEquals(1, maker.collages.size)
        val montage = maker.collages.first()

        assertEquals(2, montage.pictures.size)
        assertEquals(10, montage.width)
        assertEquals(3, montage.height)
    }

    @Test
    fun createATallMontage(){
        val pictures = listOf(
            Picture(5, 2),
            Picture(5, 3)
        )
        val maker = CollageMaker(pictures, 10, 10)

        assertEquals(1, maker.collages.size)
        val montage = maker.collages.first()

        assertEquals(2, montage.pictures.size)
        assertEquals(10, montage.width)
        assertEquals(3, montage.height)
    }
}