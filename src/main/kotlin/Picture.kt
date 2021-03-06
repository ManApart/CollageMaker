import java.awt.image.BufferedImage

data class Picture(val width: Int, val height: Int, val image: BufferedImage? = null) {
    val area = width * height
}