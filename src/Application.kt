package com.example

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import freemarker.cache.ClassTemplateLoader
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.freemarker.FreeMarker
import io.ktor.freemarker.FreeMarkerContent
import io.ktor.gson.gson
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.html.*
import kotlinx.html.*
import kotlinx.css.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    val client = HttpClient(Apache) {
    }

    install(StatusPages) {
        exception<Throwable> { e->
            call.respondText(e.localizedMessage, ContentType.Text.Plain, HttpStatusCode.InternalServerError)
        }
    }
    install(ContentNegotiation) {
        gson()
    }
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    routing {
        this.root()

        get("/html-dsl") {
            call.respondHtml {
                body {
                    h1 { +"HTML" }
                    ul {
                        for (n in 1..10) {
                            li { +"$n" }
                        }
                    }
                }
            }
        }

        get("/styles.css") {
            call.respondCss {
                body {
                    backgroundColor = Color.red
                }
                p {
                    fontSize = 2.em
                }
                rule("p.myclass") {
                    color = Color.blue
                }
            }
        }


        this.rootPost()
        this.users()

        post("/verify") {
            //call.respond(Response(status = "ok"))
            val request = call.receive<Request>()
            call.respond(request)
        }

        get("/test") {
            val user = Request("userId", "packagename", "productId", "token")
            call.respond(FreeMarkerContent("test.ftl", mapOf("subscriptions" to user)))
        }
    }
}

//@JsonClass(generateAdapter = true)
data class Request(
    @Expose
    @SerializedName("userId")
    val userId: String,
    @Expose
    @SerializedName("packageName")
    val packageName: String,
    @Expose
    @SerializedName("productId")
    val productId: String,
    @Expose
    @SerializedName("token")
    val token: String
)

data class Response(
    @Expose
    @SerializedName("status")
    val status: String
)

fun FlowOrMetaDataContent.styleCss(builder: CSSBuilder.() -> Unit) {
    style(type = ContentType.Text.CSS.toString()) {
        +CSSBuilder().apply(builder).toString()
    }
}

fun CommonAttributeGroupFacade.style(builder: CSSBuilder.() -> Unit) {
    this.style = CSSBuilder().apply(builder).toString().trim()
}

suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
    this.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
}
