package com.example.demo.views


import com.example.demo.views.entities.EntityFragment
import com.example.demo.views.login.RegisterView
import tornadofx.Controller

class HomeController : Controller() {
    init{

    }

    fun newEntity(): EntityFragment {
        log.info("new entity")
        return EntityFragment()
    }
}