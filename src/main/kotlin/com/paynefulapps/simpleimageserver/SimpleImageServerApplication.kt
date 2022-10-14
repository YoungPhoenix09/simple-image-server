package com.paynefulapps.simpleimageserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleImageServerApplication

fun main(args: Array<String>) {
	runApplication<SimpleImageServerApplication>(*args)
}
