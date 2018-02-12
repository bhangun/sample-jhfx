package com.example.demo.account

import javafx.beans.property.StringProperty
import tornadofx.*

class User {
    var username by property<String>()
    fun usernameProperty() = getProperty(User::username)

    var password by property<String>()
    fun passwordProperty() = getProperty(User::password)

    var email by property<String>()
    fun emailProperty() = getProperty(User::email)

    override fun toString() = username
}

class UserModel : ItemViewModel<User>(User()) {
    val username: StringProperty = bind { item?.usernameProperty() }
    val password: StringProperty = bind { item?.passwordProperty() }
    val email: StringProperty = bind { item?.emailProperty() }
}

