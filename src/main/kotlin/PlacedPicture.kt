data class PlacedPicture(val picture: Picture, val origin: Point = Point()) {
    val bounds = Rectangle(origin, picture.width, picture.height)
    val isLandscape = picture.width >= picture.height

}