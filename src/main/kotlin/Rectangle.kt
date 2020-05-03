data class Rectangle(val origin: Point = Point(), val width: Int = 0, val height: Int = 0) {
    val max = Point(origin.x + width, origin.y + height)
    val area = width*height

    override fun toString(): String {
        return "$origin, $max"
    }

    fun intersects(other: Rectangle): Boolean {
        return when{
            (origin.x >= other.max.x || other.origin.x >= max.x) -> false
            (origin.y >= other.max.y || other.origin.y >= max.y) -> false
             else -> true
        }
    }
}

fun List<Rectangle>.intersects(rectangle: Rectangle) : Boolean {
    return any { it.intersects(rectangle) }
}