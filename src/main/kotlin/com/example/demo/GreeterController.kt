package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("greeter")
class GreeterController {
    @GetMapping("/hello")
    fun hello(@RequestParam("name") name: String): HelloResponse {
        return HelloResponse("Hello ${name}")
    }
}

data class HelloResponse(val message: String)