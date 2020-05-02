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
        val montage = Collage(pictures, targetWidth, targetHeight)
        for (picture in montage.pictures.map { it.picture }) {
            pictures.remove(picture)
            pictures.remove(picture)
        }
        if (montage.pictures.size > 1) {
            collages.add(montage)
        }
    }

}