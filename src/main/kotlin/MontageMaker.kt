class MontageMaker(
    pictures: List<Picture> = listOf(),
    private val targetWidth: Int = 1920,
    private val targetHeight: Int = 1080
) {
    private val picturesByWidth = pictures.sortedBy { it.width }.toMutableList()
    private val picturesByHeight = pictures.sortedBy { it.height }.toMutableList()

    val montages = buildMontages()

    private fun buildMontages(): List<Montage> {
        val montages = mutableListOf<Montage>()
        while (picturesByWidth.isNotEmpty()) {
            buildMontage(montages)
        }
        return montages
    }

    private fun buildMontage(montages: MutableList<Montage>) {
        val montage = Montage(picturesByWidth, picturesByHeight, targetWidth, targetHeight)
        for (picture in montage.pictures.map { it.picture }) {
            picturesByWidth.remove(picture)
            picturesByHeight.remove(picture)
        }
        if (montage.pictures.size > 1) {
            montages.add(montage)
        }
    }

}