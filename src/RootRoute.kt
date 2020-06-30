package com.example

import io.ktor.application.call
import io.ktor.http.ContentType
import io.ktor.request.receive
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post

fun Routing.root() {
    get("/") {
        call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
    }
}

fun Routing.rootPost() {
    post("/") {
        val post = call.receive<String>()
        call.respondText("Received $post from body", ContentType.Text.Plain )
    }
}