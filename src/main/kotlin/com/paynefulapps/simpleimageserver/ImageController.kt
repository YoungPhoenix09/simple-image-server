package com.paynefulapps.simpleimageserver

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.logging.Logger

@RestController
@RequestMapping("/image")
class ImageController {
    val logger = Logger.getLogger("com.paynefulapps.simpleimageserver.ImageController")

    @GetMapping
    fun testMethod(): JsonNode {
        logger.info("Request received!")
        return ObjectMapper().valueToTree("Get Recieved!")
    }
}
