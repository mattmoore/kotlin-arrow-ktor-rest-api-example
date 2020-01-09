package io.mattmoore.examples.kotlin.arrow.ktor

import arrow.core.Either
import arrow.fx.IO
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.user() {
    route("/users") {
        get("/") {
          val response = getUsers().attempt().map {
              when (it) {
                  is Either.Left -> mapOf("error" to "Users could not be loaded.")
                  is Either.Right -> it.b
              }
          }
          call.respond(response.suspended())
        }

        get("/{id}") {
            val response = getUser({ call.parameters["id"]?.toInt()!! }).attempt().map {
                when (it) {
                    is Either.Left -> mapOf("error" to "User not found.")
                    is Either.Right -> it.b
                }
            }
            call.respond(response.suspended())
        }
    }
}
