package com.buddamanse.seairline

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SeAirlineApplication

fun main(args: Array<String>) {
    runApplication<SeAirlineApplication>(*args)
}
