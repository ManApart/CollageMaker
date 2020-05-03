private const val targetFolder = "./testFiles/"
private const val targetWidth = 1920
private const val targetHeight = 1080

fun main() {
    val pictures = parsePictures(targetFolder)
    val montageMaker = CollageMaker(pictures, targetWidth, targetHeight)

    for (i in montageMaker.collages.indices) {
        val filePath = targetFolder + "output/$i.png"
        val image = montageMaker.collages[i].image
        writeImage(filePath, image)
    }
}

