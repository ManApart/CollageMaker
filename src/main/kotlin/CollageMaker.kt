class CollageMaker(
    pictures: List<Picture> = listOf(),
    private val targetWidth: Int = 1920,
    private val targetHeight: Int = 1080
) {
    private val pictures = pictures.toMutableList()

    val montages = buildMontages()

    private fun buildMontages(): List<Collage> {
        val montages = mutableListOf<Collage>()
        while (pictures.isNotEmpty()) {
            buildMontage(montages)
        }
        return montages
    }

    private fun buildMontage(collages: MutableList<Collage>) {
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