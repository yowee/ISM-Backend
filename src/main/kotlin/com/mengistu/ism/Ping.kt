package com.mengistu.ism

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class MyController {

    @GetMapping("/private")
    fun securedEndpoint(): String {
        return "This is a secured endpoint. Only authenticated users can access it."
    }

    @GetMapping("/public")
    fun publicEndpoint(): String {
        return "This is a public endpoint. Everyone can access it."
    }
}
