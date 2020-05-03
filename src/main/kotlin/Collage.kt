import java.awt.image.BufferedImage
import kotlin.math.max

class Collage(
    picturesByWidth: List<Picture>,
    targetWidth: Int,
    targetHeight: Int
) {
    val pictures = mutableListOf<PlacedPicture>()
    private val rectangles = mutableListOf<Rectangle>()
    var width = 0
        private set
    var height = 0
        private set

    init {
        buildPictures(picturesByWidth, targetWidth, targetHeight)
    }

    val image = createImage()

    private fun buildPictures(pictures: List<Picture>, targetWidth: Int, targetHeight: Int) {
        val targetMaxWidth = max(targetWidth, pictures.maxBy { it.width }?.width ?: 0)
        val targetMaxHeight = max(targetHeight, pictures.maxBy { it.height }?.height ?: 0)
        return pictures.sortedBy { it.width }.forEach {
            attemptToAddPicture(it, targetMaxWidth, targetMaxHeight)
        }
    }

    private fun attemptToAddPicture(pic: Picture, targetWidth: Int, targetHeight: Int) {
        val origin = findPlaceFor(pic, targetWidth, targetHeight)
        if (origin != null) {
            val placed = PlacedPicture(pic, origin.copy())
            width = max(width, placed.bounds.max.x)
            height = max(height, placed.bounds.max.y)
            pictures.add(placed)
            rectangles.add(Rectangle())
        }
    }

    private fun findPlaceFor(pic: Picture, targetWidth: Int, targetHeight: Int): Point? {
        return if (pictures.isEmpty()) {
            Point()
        } else {
            val nextToOptions = pictures.filter { canFitAdjacentTo(it, pic, targetWidth, targetHeight) }
                .map { Point(it.bounds.max.x, it.bounds.origin.y) }

            val belowOptions = pictures.filter { canFitBelowOf(it, pic, targetWidth, targetHeight) }
                .map { Point(it.bounds.origin.x, it.bounds.max.y) }

            (nextToOptions + belowOptions).firstOrNull {
                !rectangles.intersects(Rectangle(it, width, height))
            }
        }
    }

    private fun canFitAdjacentTo(
        existingPicture: PlacedPicture,
        pic: Picture,
        targetWidth: Int,
        targetHeight: Int
    ): Boolean {
        return existingPicture.bounds.max.x + pic.width <= targetWidth && existingPicture.bounds.origin.y + pic.height <= targetHeight
    }

    private fun canFitBelowOf(
        existingPicture: PlacedPicture,
        pic: Picture,
        targetWidth: Int,
        targetHeight: Int
    ): Boolean {
        return existingPicture.bounds.max.y + pic.height <= targetHeight && existingPicture.bounds.origin.x + pic.width <= targetWidth
    }

    private fun createImage() : BufferedImage {
        val image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)

        val g2d = image.createGraphics()
        pictures.forEach {
            g2d.drawImage(it.picture.image, it.origin.x, it.origin.y, null)
        }

        return image
    }

}