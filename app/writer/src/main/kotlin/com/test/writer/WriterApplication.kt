package com.test.writer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WriterApplication

fun main(args: Array<String>) {
	runApplication<WriterApplication>(*args)
}
