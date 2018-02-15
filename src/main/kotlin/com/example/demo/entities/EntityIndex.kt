package com.example.demo.entities


import com.example.demo.account.UserFragment
import com.example.demo.shared.administration.ConfigurationFragment
import com.example.demo.shared.administration.HealthFragment
import com.example.demo.shared.administration.MetricFragment
import tornadofx.*

class EntityIndex : Controller() {

    init{

    }

    fun newEntity(): UserFragment {
        return UserFragment()
    }

    fun userManagement(): UserFragment {
        return UserFragment()
    }

    fun metric(): MetricFragment {
        return MetricFragment()
    }
    fun health(): HealthFragment {
        return HealthFragment()
    }
    fun configuration(): ConfigurationFragment {
        return ConfigurationFragment()
    }
}
