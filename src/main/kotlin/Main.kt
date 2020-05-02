private val targetFolder = "./testFiles/"
private val targetWidth = 1920
private val targetHeight = 1080

fun main() {
    val pictures = parsePictures(targetFolder)
    val montageMaker = MontageMaker(pictures, targetWidth, targetHeight)

    montageMaker.montages.forEach {
        it.writeImage(targetFolder + "output/")
    }
}

