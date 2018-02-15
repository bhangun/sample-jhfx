package com.example.demo.account

import com.example.demo.shared.BaseController
import com.example.demo.shared.account.UserView
import tornadofx.*

class UserFragment : Fragment("Entity View") {
    val userView : UserView by inject()
    val userForm : UserForm by inject()
    val base: BaseController by inject()
    override val root = borderpane()
    init{
        log.info("new entity fragment")
        with(root) {
            center = userView.root
        }
    }
}

class UserFragmentModel : ItemViewModel<UserFragment>() {
    val root = bind(UserFragment::root)
}

