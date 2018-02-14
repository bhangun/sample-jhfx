package com.example.demo.shared.home


import com.example.demo.account.EntityFragment
import com.example.demo.account.UserFragment
import tornadofx.Controller

class HomeController : Controller() {

    init{

    }

    fun newEntity(): UserFragment {
        return UserFragment()
    }
}