package com.paynefulapps.simpleimageserver

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.time.LocalDate
import java.util.logging.Logger

@Service
class ImagePersister(
    @Autowired val imageRepository: ImageRepository
) {
    val logger = Logger.getLogger("com.paynefulapp.simpleimageserver.ImagePersister")

    fun storeImage(imageFile: File): Image {
        val filePath = Paths.get(imageFile.path)
        val fileBytes = Files.readAllBytes(filePath)

        val image = Image(
            created = LocalDate.now(),
            imageName = imageFile.name,
            imageData = fileBytes
        )

        return imageRepository.save(image)
    }
}