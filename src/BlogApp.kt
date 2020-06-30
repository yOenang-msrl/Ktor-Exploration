package com.example

import io.ktor.application.*
import io.ktor.features.CallLogging
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.netty.handler.codec.DefaultHeaders

//fun main(args: Array<String>) {
//    embeddedServer(Netty, 8080) {
//        routing {
//            get("/") {
//                call.respondText("My Example Blog", ContentType.Text.Html)
//            }
//        }
//    }.start(wait = true)
//}

//fun Application.module() {
//    install(DefaultHeaders)
//    install(CallLogging)
//    install(Routing) {
//        get("/") {
//            call.respondText("My Example Blog2", ContentType.Text.Html)
//        }
//    }
//}
//
//fun main(args: Array<String>) {
//    embeddedServer(Netty, 8080, watchPaths = listOf("BlogAppKt"), module = Application::module).start()
//}