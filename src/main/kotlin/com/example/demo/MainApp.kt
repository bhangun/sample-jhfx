package com.example.demo


import com.example.demo.views.Styles
import com.example.demo.views.login.LoginView
import tornadofx.*


class MainApp : App(LoginView::class, Styles::class)