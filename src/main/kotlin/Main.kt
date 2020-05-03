//private const val targetFolder = "./testFiles/"
private const val targetFolder = "B:/Pictures/Lord of the rings/Paintings/"
private const val targetWidth = 1920
private const val targetHeight = 1080
private const val includeSingleImage = true

fun main() {
    println("Scanning $targetFolder.")
    val pictures = parsePictures(targetFolder)
    println("Found ${pictures.size} pictures.")

    val montageMaker = CollageMaker(pictures, targetWidth, targetHeight, includeSingleImage)
    println("Created ${montageMaker.collages.size} collages.")


    for (i in montageMaker.collages.indices) {
//        val filePath = "./testFiles/output/$i.png"
        val filePath = targetFolder + "output/$i.png"
        val image = montageMaker.collages[i].image
        writeImage(filePath, image)
        println("Wrote image $filePath")
    }
}

