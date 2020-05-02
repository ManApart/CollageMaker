import java.io.File
import javax.imageio.ImageIO

fun parsePictures(targetFolder: String): List<Picture> {
    return getFiles(targetFolder).map { createPicture(it) }
}


private fun getFiles(path: String): List<File> {
    val folder = File(path)
    return if (folder.exists() && folder.isDirectory) {
        @Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
        folder.listFiles().filterNotNull().filter { it.name.endsWith(".jpg") }.toList()
    } else {
        listOf()
    }
}


fun createPicture(file: File): Picture {
    val image = ImageIO.read(file)
    return Picture(image.width, image.height, file.path)
}