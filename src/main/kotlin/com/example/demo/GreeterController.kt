package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("greeter")
class GreeterController {
    var greeter: Greeter? = null
        @Autowired
        set(value) {
            field = value
        }

    @GetMapping("/hello")
    fun hello(@RequestParam("name") name: String): HelloResponse {
        return HelloResponse("Hello ${name}")
    }

    @GetMapping("/hello/{name}")
    fun helloPathValue(@PathVariable("name") name: String): HelloResponse {
        val message = greeter?.sayHello(name) ?: return HelloResponse("")
        return HelloResponse(message)
    }

    @PostMapping("/hello")
    fun helloByPost(@RequestBody request: HelloRequest): HelloResponse {
        return HelloResponse("Hello ${request.name}")
    }
}

data class HelloResponse(val message: String)

data class HelloRequest(val name: String)