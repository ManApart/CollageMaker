class CollageMaker(
    pictures: List<Picture> = listOf(),
    private val targetWidth: Int = 1920,
    private val targetHeight: Int = 1080
) {
    private val pictures = pictures.toMutableList()

    val collages = buildCollages()

    private fun buildCollages(): List<Collage> {
        val montages = mutableListOf<Collage>()
        while (pictures.isNotEmpty()) {
            buildCollage(montages)
        }
        return montages
    }

    private fun buildCollage(collages: MutableList<Collage>) {
        val collage = Collage(pictures, targetWidth, targetHeight)
        for (picture in collage.pictures.map { it.picture }) {
            pictures.remove(picture)
            pictures.remove(picture)
        }
        if (collage.pictures.size > 1) {
            println("Created collage ${collage.width} x ${collage.height}.")
            collages.add(collage)
        }
    }

}