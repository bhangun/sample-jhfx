package com.example.demo


import com.example.demo.views.Styles
import com.example.demo.views.login.LoginScreen
import tornadofx.*


class MainApp : App(LoginScreen::class, Styles::class)