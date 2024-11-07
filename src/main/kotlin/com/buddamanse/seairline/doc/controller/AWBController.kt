package com.buddamanse.seairline.doc.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1")
class AWBController {

    @GetMapping("/getAWB")
    fun getAWB(@RequestParam ): AWB {
        return
    }
}