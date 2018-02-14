package com.example.demo.shared.account


import com.example.demo.shared.login.LoginController
import tornadofx.Controller

class RegisterController : Controller() {
    val registerView: RegisterForm by inject()
val loginController: LoginController by inject()
    init{

    }
}