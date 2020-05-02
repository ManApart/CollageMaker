data class PlacedPicture(val picture: Picture, val x: Int, val y: Int) {
    val maxX = x + picture.width
    val maxY = y + picture.height
}