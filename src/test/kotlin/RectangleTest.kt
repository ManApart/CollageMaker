import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class RectangleTest {

    @Test
    fun noOverlap() {
        val r1 = Rectangle(width = 1, height = 1)
        val r2 = Rectangle(Point(2, 2), 1, 1)
        assertFalse(r1.intersects(r2))
        assertFalse(r2.intersects(r1))
    }

    @Test
    fun overlap() {
        val r1 = Rectangle(width = 10, height = 10)
        val r2 = Rectangle(Point(2, 2), 1, 1)
        assertTrue(r1.intersects(r2))
        assertTrue(r2.intersects(r1))
    }
}