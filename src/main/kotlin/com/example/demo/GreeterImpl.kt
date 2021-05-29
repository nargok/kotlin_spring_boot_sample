package com.example.demo

import org.springframework.stereotype.Component

@Component // Dependency Injectionの対象クラスとする
class GreeterImpl: Greeter {
    override fun sayHello(name: String) = "Hello $name"
}