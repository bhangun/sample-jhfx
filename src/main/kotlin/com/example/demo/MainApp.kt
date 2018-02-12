package com.example.demo


import com.example.demo.shared.Styles
import com.example.demo.shared.login.LoginView
import tornadofx.*


class MainApp : App(LoginView::class, Styles::class)