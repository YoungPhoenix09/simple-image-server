package com.paynefulapps.simpleimageserver

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.io.File
import java.io.FileOutputStream

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ImagePersisterTest(
    @Autowired val imagePersister :ImagePersister,
    @Autowired val imageRepository: ImageRepository
) {

    val file = File("./setuplocal.sh")

    @Test
    fun `it can save the file in an entity`() {
        val image = imagePersister.storeImage(file)

        assertNotNull(image.id)
    }

    @Test
    fun `it can properly reproduce a saved file`() {
        val revivedFile = File("./revivedFile.sh")

        imagePersister.storeImage(file)

        val image = imageRepository.findAll().first()

        val bytes = image.imageData

        FileOutputStream(revivedFile).write(bytes)

        assertEquals(revivedFile.readLines(), file.readLines())

        revivedFile.delete()
    }

    @AfterEach
    fun cleanUp() {
        imageRepository.deleteAll()
    }
}