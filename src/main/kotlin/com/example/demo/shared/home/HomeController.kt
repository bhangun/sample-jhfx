package com.example.demo.shared.home


import com.example.demo.shared.entities.EntityFragment
import tornadofx.Controller

class HomeController : Controller() {
    init{

    }

    fun newEntity(): EntityFragment {
        log.info("new entity")
        return EntityFragment()
    }
}