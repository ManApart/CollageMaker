class MontageMaker(private val targetWidth: Int, private val targetHeight: Int, pictures: List<Picture> = listOf()) {
    private val picturesByWidth = pictures.sortedBy { it.width }.toMutableList()
    private val picturesByHeight = pictures.sortedBy { it.height }.toMutableList()

    fun buildMontages() : List<Montage> {
        return listOf()
    }
}