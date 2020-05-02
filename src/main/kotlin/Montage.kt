import kotlin.math.max

class Montage(
    picturesByWidth: List<Picture>,
    picturesByHeight: List<Picture>,
    targetWidth: Int,
    targetHeight: Int
) {
    val pictures = buildPictures(picturesByWidth, picturesByHeight, targetWidth, targetHeight)
    var width = 0
        private set
    var height = 0
        private set

    private fun buildPictures(
        picturesByWidth: List<Picture>,
        picturesByHeight: List<Picture>,
        targetWidth: Int,
        targetHeight: Int
    ): List<PlacedPicture> {
        var w = 0
        var h = 0
        var pickWidth = false

        val pictures = mutableListOf<PlacedPicture>()
        var pic: Picture? = picturesByWidth[w]
        while (pic != null) {
            attemptToAddPicture(pic, pictures, targetWidth, targetHeight, pickWidth)

            pickWidth = !pickWidth
            if (pickWidth && w < picturesByWidth.size) {
                pic = picturesByWidth[w]
                w++
            } else if (!pickWidth && h < picturesByHeight.size) {
                pic = picturesByHeight[h]
                h++
            } else {
                pic = null
            }

        }
        return pictures
    }

    private fun attemptToAddPicture(
        pic: Picture,
        pictures: MutableList<PlacedPicture>,
        targetWidth: Int,
        targetHeight: Int,
        horizontal: Boolean
    ) {
        if (isNew(pic, pictures) && fits(pic, targetWidth, targetHeight)) {
            val placed = if (horizontal){
                PlacedPicture(pic, width, 0)
            } else {
                PlacedPicture(pic, 0, height)
            }
            width = max(width, placed.maxX)
            height = max(height, placed.maxY)
            pictures.add(placed)
        }
    }

    private fun isNew(pic: Picture, pics: List<PlacedPicture>): Boolean {
        return pic !in pics.map { it.picture }
    }

    private fun fits(pic: Picture, targetWidth: Int, targetHeight: Int): Boolean {
        return true
    }



    fun writeImage(folder: String) {

    }
}