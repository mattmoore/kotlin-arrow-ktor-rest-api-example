package io.mattmoore.examples.kotlin.arrow.ktor

import arrow.fx.IO

class User(
  var id: Int,
  var firstName: String,
  var lastName: String
)

var userDatabase = mutableListOf<User>(
  User(1, "Matt", "Moore"),
  User(2, "Jane", "Doe")
)

fun getUsers() = IO {
  userDatabase
}

fun getUser(id: () -> Int) = IO {
  userDatabase.find {
    user -> user.id == id()
  }!!
}
